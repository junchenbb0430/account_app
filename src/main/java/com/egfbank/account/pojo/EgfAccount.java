package com.egfbank.account.pojo;

import java.math.BigDecimal;
import java.util.Date;


public class EgfAccount {

	 private String accountNo;

	 private String accountType;

	 private BigDecimal balance;

	 private BigDecimal freezeAmount;

	 private String status;

	 private String cardId;

	 private String aliasName;

	 private String accountTitle;

	 private String accountDirection;

	 private BigDecimal depositAmount;

	 private BigDecimal systemAmount;

	 private String freezeMode;

	 private BigDecimal previousBalance;

	 private Date createTime;

	 private Date updateTime;

		public void setAccountNo (String accountNo) {
			this.accountNo = accountNo;
		}

		public String getAccountNo () {
			return accountNo;
		}

		public void setAccountType (String accountType) {
			this.accountType = accountType;
		}

		public String getAccountType () {
			return accountType;
		}

		public void setBalance (BigDecimal balance) {
			this.balance = balance;
		}

		public BigDecimal getBalance () {
			return balance;
		}

		public void setFreezeAmount (BigDecimal freezeAmount) {
			this.freezeAmount = freezeAmount;
		}

		public BigDecimal getFreezeAmount () {
			return freezeAmount;
		}

		public void setStatus (String status) {
			this.status = status;
		}

		public String getStatus () {
			return status;
		}

		public void setCardId (String cardId) {
			this.cardId = cardId;
		}

		public String getCardId () {
			return cardId;
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

		public void setAccountDirection (String accountDirection) {
			this.accountDirection = accountDirection;
		}

		public String getAccountDirection () {
			return accountDirection;
		}

		public void setDepositAmount (BigDecimal depositAmount) {
			this.depositAmount = depositAmount;
		}

		public BigDecimal getDepositAmount () {
			return depositAmount;
		}

		public void setSystemAmount (BigDecimal systemAmount) {
			this.systemAmount = systemAmount;
		}

		public BigDecimal getSystemAmount () {
			return systemAmount;
		}

		public void setFreezeMode (String freezeMode) {
			this.freezeMode = freezeMode;
		}

		public String getFreezeMode () {
			return freezeMode;
		}

		public void setPreviousBalance (BigDecimal previousBalance) {
			this.previousBalance = previousBalance;
		}

		public BigDecimal getPreviousBalance () {
			return previousBalance;
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
