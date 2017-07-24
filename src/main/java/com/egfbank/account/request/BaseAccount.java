package com.egfbank.account.request;

import java.math.BigDecimal;
import java.util.Date;


public class BaseAccount {
	// 账号
	private String accountNo;
	// 账户类型
	private String accountType;
	//余额
	private BigDecimal balance;
	// 冻结金额
	private BigDecimal freezeAmount;
	/**
	 * 账户状态
	 */
	private String status;
	
	/**
	 * 客户ID
	 */
	private String cardId;
	
	/**
	 * 账户别名
	 */
	private String aliasName;
	
	/**
	 * 账户结账方向
	 */
	private String accountDirection;
	
	/**
	 * 充值金额
	 */
	private BigDecimal depositAmount;
	
	/**
	 * 冻结模式
	 */
	private String freezeMode;
	
	/**
	 * 渠道明细单号
	 */
	private String outerDetailOrder;
	
	/**
	 * 外部系统单号
	 */
	private String beyondOuterOder;
	
	/**
	 * 账户标题
	 */
	private String accountTitle;
	
	/**
	 * 交易日期
	 */
	private String transDate;
	
	/**
	 * 清算渠道
	 */
	private String instChannel;
	
	/**
	 * 银行ID
	 */
	private String bankId;
	
	/**
	 * 银行名称
	 */
	private String bankName;
	
	/**
	 * 对方账户
	 */
	private String otherAccountNo;
	
	/**
	 * 创建时间
	 */
	private Date createTime;

	 

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getInstChannel() {
		return instChannel;
	}

	public void setInstChannel(String instChannel) {
		this.instChannel = instChannel;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	
	public String getBeyondOuterOder() {
		return beyondOuterOder;
	}

	public void setBeyondOuterOder(String beyondOuterOder) {
		this.beyondOuterOder = beyondOuterOder;
	}

	public String getOtherAccountNo() {
		return otherAccountNo;
	}

	public void setOtherAccountNo(String otherAccountNo) {
		this.otherAccountNo = otherAccountNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	 

	public BigDecimal getFreezeAmount() {
		return freezeAmount;
	}

	public void setFreezeAmount(BigDecimal freezeAmount) {
		this.freezeAmount = freezeAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getAccountDirection() {
		return accountDirection;
	}

	public void setAccountDirection(String accountDirection) {
		this.accountDirection = accountDirection;
	}

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	 

	public String getFreezeMode() {
		return freezeMode;
	}

	public void setFreezeMode(String freezeMode) {
		this.freezeMode = freezeMode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAccountTitle() {
		return accountTitle;
	}

	public void setAccountTitle(String accountTitle) {
		this.accountTitle = accountTitle;
	}

	public String getOuterDetailOrder() {
		return outerDetailOrder;
	}

	public void setOuterDetailOrder(String outerDetailOrder) {
		this.outerDetailOrder = outerDetailOrder;
	}
	
	
}
