package com.egfbank.account.service;

import com.egfbank.account.pojo.EgfAccount;
import com.egfbank.account.request.BaseAccount;




public interface BaseAccountService {
	
	/**
	 * 开户
	 * @return
	 */
	public String openAccount(final BaseAccount baseAccount);
	
	 
	
	/**
	 * 转账
	 * @param account
	 * @param otherAccount
	 */
	public void transfer(EgfAccount account,EgfAccount otherAccount);
	
	/**
	 * 冻结
	 * @param account
	 */
	public String freezeAccount(BaseAccount baseAccount);
	
	/**
	 * 解冻
	 * @param account
	 * @return
	 */
	public String unfreezeAccount(EgfAccount account);
	
	/**
	 * 
	 * @param baseAccount
	 * @return
	 */
	public EgfAccount deposit(BaseAccount baseAccount);
}
