package com.egfbank.account.pojo;

import java.math.BigDecimal;
import java.util.Date;


public class EgfAccountLog {

	 private String accountLogId;

	 private String accountNo;

	 private String transDate;

	 private String transCode;

	 private String subTransCode;

	 private BigDecimal transBalance;

	 private BigDecimal transAmount;

	 private BigDecimal balance;

	 private String transCurrency;

	 private String transAccount;

	 private String otherAccount;

	 private String transMemo;

	 private String otherAccountLog;

	 private String accountType;

	 private String otherAccountType;

	 private String instChannel;

	 private String bankName;

	 private String payBankName;

	 private String bankId;

	 private String payBankId;

	 private String outOrderNo;

	 private String transType;

	 private String beyondOrderNo;

	 private Date createTime;

	 private Date updateTime;

		public void setAccountLogId (String accountLogId) {
			this.accountLogId = accountLogId;
		}

		public String getAccountLogId () {
			return accountLogId;
		}

		public void setAccountNo (String accountNo) {
			this.accountNo = accountNo;
		}

		public String getAccountNo () {
			return accountNo;
		}

		public void setTransDate (String transDate) {
			this.transDate = transDate;
		}

		public String getTransDate () {
			return transDate;
		}

		public void setTransCode (String transCode) {
			this.transCode = transCode;
		}

		public String getTransCode () {
			return transCode;
		}

		public void setSubTransCode (String subTransCode) {
			this.subTransCode = subTransCode;
		}

		public String getSubTransCode () {
			return subTransCode;
		}

		public void setTransBalance (BigDecimal transBalance) {
			this.transBalance = transBalance;
		}

		public BigDecimal getTransBalance () {
			return transBalance;
		}

		public void setTransAmount (BigDecimal transAmount) {
			this.transAmount = transAmount;
		}

		public BigDecimal getTransAmount () {
			return transAmount;
		}

		public void setBalance (BigDecimal balance) {
			this.balance = balance;
		}

		public BigDecimal getBalance () {
			return balance;
		}

		public void setTransCurrency (String transCurrency) {
			this.transCurrency = transCurrency;
		}

		public String getTransCurrency () {
			return transCurrency;
		}

		public void setTransAccount (String transAccount) {
			this.transAccount = transAccount;
		}

		public String getTransAccount () {
			return transAccount;
		}

		public void setOtherAccount (String otherAccount) {
			this.otherAccount = otherAccount;
		}

		public String getOtherAccount () {
			return otherAccount;
		}

		public void setTransMemo (String transMemo) {
			this.transMemo = transMemo;
		}

		public String getTransMemo () {
			return transMemo;
		}

		public void setOtherAccountLog (String otherAccountLog) {
			this.otherAccountLog = otherAccountLog;
		}

		public String getOtherAccountLog () {
			return otherAccountLog;
		}

		public void setAccountType (String accountType) {
			this.accountType = accountType;
		}

		public String getAccountType () {
			return accountType;
		}

		public void setOtherAccountType (String otherAccountType) {
			this.otherAccountType = otherAccountType;
		}

		public String getOtherAccountType () {
			return otherAccountType;
		}

		public void setInstChannel (String instChannel) {
			this.instChannel = instChannel;
		}

		public String getInstChannel () {
			return instChannel;
		}

		public void setBankName (String bankName) {
			this.bankName = bankName;
		}

		public String getBankName () {
			return bankName;
		}

		public void setPayBankName (String payBankName) {
			this.payBankName = payBankName;
		}

		public String getPayBankName () {
			return payBankName;
		}

		public void setBankId (String bankId) {
			this.bankId = bankId;
		}

		public String getBankId () {
			return bankId;
		}

		public void setPayBankId (String payBankId) {
			this.payBankId = payBankId;
		}

		public String getPayBankId () {
			return payBankId;
		}

		public void setOutOrderNo (String outOrderNo) {
			this.outOrderNo = outOrderNo;
		}

		public String getOutOrderNo () {
			return outOrderNo;
		}

		public void setTransType (String transType) {
			this.transType = transType;
		}

		public String getTransType () {
			return transType;
		}

		public void setBeyondOrderNo (String beyondOrderNo) {
			this.beyondOrderNo = beyondOrderNo;
		}

		public String getBeyondOrderNo () {
			return beyondOrderNo;
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
