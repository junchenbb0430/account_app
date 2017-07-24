package com.egfbank.account.pojo;

import java.math.BigDecimal;
import java.util.Date;


public class EgfAccountInst {

	 private String instAccountNo;

	 private String accountType;

	 private String currency;

	 private BigDecimal balance;

	 private String enabledStatus;

	 private String aliasName;

	 private String accountTitle;

	 private String balanceDirection;

	 private BigDecimal systemAmount;

	 private String transRule;

	 private BigDecimal previousBalance;

	 private String lastTransDate;

	 private String instChannelApi;

	 private Date createTime;

	 private Date updateTime;

		public void setInstAccountNo (String instAccountNo) {
			this.instAccountNo = instAccountNo;
		}

		public String getInstAccountNo () {
			return instAccountNo;
		}

		public void setAccountType (String accountType) {
			this.accountType = accountType;
		}

		public String getAccountType () {
			return accountType;
		}

		public void setCurrency (String currency) {
			this.currency = currency;
		}

		public String getCurrency () {
			return currency;
		}

		public void setBalance (BigDecimal balance) {
			this.balance = balance;
		}

		public BigDecimal getBalance () {
			return balance;
		}

		public void setEnabledStatus (String enabledStatus) {
			this.enabledStatus = enabledStatus;
		}

		public String getEnabledStatus () {
			return enabledStatus;
		}

		public void setAliasName (String aliasName) {
			this.aliasName = aliasName;
		}

		public String getAliasName () {
			return aliasName;
		}

		public void setAccountTitle (String accountTitle) {
			this.accountTitle = accountTitle;
		}

		public String getAccountTitle () {
			return accountTitle;
		}

		public void setBalanceDirection (String balanceDirection) {
			this.balanceDirection = balanceDirection;
		}

		public String getBalanceDirection () {
			return balanceDirection;
		}

		public void setSystemAmount (BigDecimal systemAmount) {
			this.systemAmount = systemAmount;
		}

		public BigDecimal getSystemAmount () {
			return systemAmount;
		}

		public void setTransRule (String transRule) {
			this.transRule = transRule;
		}

		public String getTransRule () {
			return transRule;
		}

		public void setPreviousBalance (BigDecimal previousBalance) {
			this.previousBalance = previousBalance;
		}

		public BigDecimal getPreviousBalance () {
			return previousBalance;
		}

		public void setLastTransDate (String lastTransDate) {
			this.lastTransDate = lastTransDate;
		}

		public String getLastTransDate () {
			return lastTransDate;
		}

		public void setInstChannelApi (String instChannelApi) {
			this.instChannelApi = instChannelApi;
		}

		public String getInstChannelApi () {
			return instChannelApi;
		}

		public void setCreateTime (Date createTime) {
			this.createTime = createTime;
		}

		public Date getCreateTime () {
			return createTime;
		}

		public void setUpdateTime (Date updateTime) {
			this.updateTime = updateTime;
		}

		public Date getUpdateTime () {
			return updateTime;
		}

}
