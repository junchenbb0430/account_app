package com.egfbank.account.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.egfbank.account.dao.EgfAccountDao;
import com.egfbank.account.dao.EgfAccountFreezeDao;
import com.egfbank.account.dao.EgfAccountFreezeLogDao;
import com.egfbank.account.dao.EgfAccountLogDao;
import com.egfbank.account.pojo.EgfAccount;
import com.egfbank.account.pojo.EgfAccountFreeze;
import com.egfbank.account.pojo.EgfAccountFreezeLog;
import com.egfbank.account.pojo.EgfAccountLog;
import com.egfbank.account.request.BaseAccount;
import com.egfbank.account.sequence.SequenceGenerateService;
import com.egfbank.account.service.AccountService;
import com.egfbank.account.utils.AccountConstant;
import com.egfbank.account.utils.EgfDateUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private EgfAccountDao  accountDao;
	
	@Autowired
	private EgfAccountLogDao accountLogDao;
	
	@Autowired
	private EgfAccountFreezeDao accountFreezeDao;
	
	@Autowired
	private EgfAccountFreezeLogDao accountFreezeLogDao;
	
	@Autowired
	private SequenceGenerateService sequenceService;
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	/**
	 * 返回开户成功的账号
	 */
	public String openAccount(final BaseAccount baseAccount) {
		
		 
		EgfAccount account = transactionTemplate.execute(new TransactionCallback<EgfAccount>(){

			public EgfAccount doInTransaction(TransactionStatus status) {
				EgfAccount account = new EgfAccount();
				account.setAccountNo(sequenceService.accountSequenceGenerator());
				account.setAccountType(AccountConstant.ACCOUNT_TYPE_ALL);
				account.setAliasName(baseAccount.getAliasName());
				account.setCreateTime(new Date());
				account.setAccountTitle(baseAccount.getAccountTitle());
				account.setCardId(EgfDateUtils.formateCurrentDateTime());
				account.setBalance(baseAccount.getBalance());
				account.setStatus(baseAccount.getStatus());
				account.setDepositAmount(baseAccount.getDepositAmount());
				account.setAccountDirection(baseAccount.getAccountDirection());
				account.setFreezeAmount(baseAccount.getFreezeAmount());
				accountDao.insertEgfAccount(account);
				return account;
			}
			
		});
		return account.getAccountNo();
	}

	public void transfer(EgfAccount account, EgfAccount otherAccount) {
		// TODO Auto-generated method stub

	}
	
	/***
	 * 冻结金额
	 */
	public String freezeAccount(BaseAccount baseAccount) {
		EgfAccount account = new EgfAccount();
		account.setAccountNo(baseAccount.getAccountNo());
		// 锁住账户记录
		List<EgfAccount> accountList = accountDao.queryEgfAccountForUpdate(account);
		account = accountList.get(0);
		account.setBalance(account.getBalance().subtract(baseAccount.getFreezeAmount()));
		account.setFreezeAmount(baseAccount.getFreezeAmount());
		account.setSystemAmount(baseAccount.getFreezeAmount());
		account.setUpdateTime(new Date());
		account.setStatus(AccountConstant.ACCOUNT_STATUS_FREEZE);
		accountDao.updateEgfAccount(account);
		// 插入冻结流水 
		EgfAccountFreeze accountFreeze = new EgfAccountFreeze();
		accountFreeze.setFreezeId(sequenceService.accountFreezeSequenceGenerator());//账户ID
		accountFreeze.setAccountNo(account.getAccountNo());// 账号
		accountFreeze.setFreezeType(baseAccount.getFreezeMode());//冻结类型
		accountFreeze.setFreezeAmount(baseAccount.getFreezeAmount());
		accountFreeze.setCreateTime(new Date());
		accountFreeze.setUpdateTime(new Date());
		accountFreezeDao.insertEgfAccountFreeze(accountFreeze);
		// 插入冻结流水日志
		EgfAccountFreezeLog acctFreezeLog = new EgfAccountFreezeLog();
		acctFreezeLog.setFreezeIdLog(sequenceService.accountFreezeLogSequenceGenerator());
		acctFreezeLog.setOutOrderNo(baseAccount.getOuterDetailOrder());//前置系统内部单号
		acctFreezeLog.setActionType(baseAccount.getFreezeMode());//交易类型：F-冻结，U-解冻
		acctFreezeLog.setAmount(baseAccount.getFreezeAmount());
		acctFreezeLog.setFreezeType(baseAccount.getFreezeMode());//冻结类型
		acctFreezeLog.setTotalFreezeAmount(baseAccount.getFreezeAmount());//总冻结金额
		acctFreezeLog.setTypeFreezeAmount(baseAccount.getFreezeAmount());
		acctFreezeLog.setCreateTime(new Date());
		accountFreezeLogDao.insertEgfAccountFreezeLog(acctFreezeLog); 
		// 
		
		return accountFreeze.getFreezeId();
	}
	/**
	 * 解冻
	 */
	public String unfreezeAccount(EgfAccount account) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 充值并冻结
	 */
	public String depositAndFreeze(BaseAccount baseAccount) {
		EgfAccount account = new EgfAccount();
		account = accountDao.queryEgfAccountForUpdate(account).get(0); 
		account.setBalance(baseAccount.getDepositAmount().add(account.getBalance()));
		account.setDepositAmount(baseAccount.getDepositAmount().add(account.getDepositAmount()));
		account.setUpdateTime(new Date());
		accountDao.updateEgfAccount(account);
		//插入account_log流水 飞雪连天射白鹿，笑书神侠倚碧鸳；畅游天津遇半仙，年事已高重出山；半仙素材取不完，再续神州武侠缘；
		// 中华儿女齐叫好，金庸人生吊炸天
		EgfAccountLog accountLog = new EgfAccountLog();
		accountLog.setAccountLogId(sequenceService.accountLogSequenceGenerator());
		accountLog.setAccountNo(account.getAccountNo());
		accountLog.setTransDate(baseAccount.getTransDate());
		accountLog.setBalance(account.getBalance());
		accountLog.setTransBalance(baseAccount.getDepositAmount());
		accountLog.setBankId(baseAccount.getBankId());
		accountLog.setBankName(baseAccount.getBankName());
		accountLog.setInstChannel(baseAccount.getInstChannel());//清算渠道
		accountLog.setOutOrderNo(baseAccount.getOuterDetailOrder());
		accountLog.setBeyondOrderNo(baseAccount.getBeyondOuterOder());
		accountLog.setCreateTime(new Date());
		accountLogDao.insertEgfAccountLog(accountLog);
		// 插入冻结流水 
		EgfAccountFreeze accountFreeze = new EgfAccountFreeze();
		accountFreeze.setFreezeId(sequenceService.accountFreezeSequenceGenerator());//账户ID
		accountFreeze.setAccountNo(account.getAccountNo());// 账号
		accountFreeze.setFreezeType(baseAccount.getFreezeMode());//冻结类型
		accountFreeze.setFreezeAmount(baseAccount.getFreezeAmount());
		accountFreeze.setCreateTime(new Date());
		accountFreeze.setUpdateTime(new Date());
		accountFreezeDao.insertEgfAccountFreeze(accountFreeze);
		// 插入冻结流水日志
		EgfAccountFreezeLog acctFreezeLog = new EgfAccountFreezeLog();
		acctFreezeLog.setFreezeIdLog(sequenceService.accountFreezeLogSequenceGenerator());
		acctFreezeLog.setOutOrderNo(baseAccount.getOuterDetailOrder());//前置系统内部单号
		acctFreezeLog.setActionType(baseAccount.getFreezeMode());//交易类型：F-冻结，U-解冻
		acctFreezeLog.setAmount(baseAccount.getFreezeAmount());
		acctFreezeLog.setFreezeType(baseAccount.getFreezeMode());//冻结类型
		acctFreezeLog.setTotalFreezeAmount(baseAccount.getFreezeAmount());//总冻结金额
		acctFreezeLog.setTypeFreezeAmount(baseAccount.getFreezeAmount());
		acctFreezeLog.setCreateTime(new Date());
		accountFreezeLogDao.insertEgfAccountFreezeLog(acctFreezeLog);  
		return accountFreeze.getFreezeId();
	}

	/**
	 * 解冻并转账
	 */
	public String unfreezeAndTransfer(EgfAccount account,
			EgfAccount otherAccount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 转账并冻结
	 */
	public String transferAndFreeze() {
		// TODO Auto-generated method stub
		return null;
	}

	public String unfreezeAndWithdraw(EgfAccount account) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args){
		 
	}
	
	public EgfAccount deposit(BaseAccount baseAccount) {
		// TODO Auto-generated method stub
		return null;
	}
}
