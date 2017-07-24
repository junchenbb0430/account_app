package com.egfbank.account.service;

import com.egfbank.account.pojo.EgfAccount;
import com.egfbank.account.request.BaseAccount;

/**
 * 
 * @author tonny
 *
 */
public interface AccountService extends BaseAccountService {
	
	/**
	 * 充值并冻结服务
	 * @param account
	 * @return
	 */
	public String depositAndFreeze(BaseAccount baseAccount);
	
	/**
	 * 解冻并转账：解冻，转账
	 * @param account
	 * @param otherAccount
	 * @return
	 */
	public String unfreezeAndTransfer(EgfAccount account,EgfAccount otherAccount);
	
	/**
	 * 转账并冻结
	 * @return
	 */
	public String transferAndFreeze();
	
	/**
	 * 解冻并提现
	 * @param account
	 * @return
	 */
	public String unfreezeAndWithdraw(EgfAccount account);
}
