package com.egfbank.account.pojo;

import java.math.BigDecimal;
import java.util.Date;


public class EgfAccountFreezeLog {

	 private String freezeIdLog;

	 private String accountNo;

	 private String outOrderNo;

	 private String actionType;

	 private BigDecimal amount;

	 private String freezeType;

	 private BigDecimal totalFreezeAmount;

	 private BigDecimal typeFreezeAmount;

	 private String freezeMemo;

	 private String beyondOrderNo;

	 private Date transTime;

	 private Date createTime;

		public void setFreezeIdLog (String freezeIdLog) {
			this.freezeIdLog = freezeIdLog;
		}

		public String getFreezeIdLog () {
			return freezeIdLog;
		}

		public void setAccountNo (String accountNo) {
			this.accountNo = accountNo;
		}

		public String getAccountNo () {
			return accountNo;
		}

		public void setOutOrderNo (String outOrderNo) {
			this.outOrderNo = outOrderNo;
		}

		public String getOutOrderNo () {
			return outOrderNo;
		}

		public void setActionType (String actionType) {
			this.actionType = actionType;
		}

		public String getActionType () {
			return actionType;
		}

		public void setAmount (BigDecimal amount) {
			this.amount = amount;
		}

		public BigDecimal getAmount () {
			return amount;
		}

		public void setFreezeType (String freezeType) {
			this.freezeType = freezeType;
		}

		public String getFreezeType () {
			return freezeType;
		}

		public void setTotalFreezeAmount (BigDecimal totalFreezeAmount) {
			this.totalFreezeAmount = totalFreezeAmount;
		}

		public BigDecimal getTotalFreezeAmount () {
			return totalFreezeAmount;
		}

		public void setTypeFreezeAmount (BigDecimal typeFreezeAmount) {
			this.typeFreezeAmount = typeFreezeAmount;
		}

		public BigDecimal getTypeFreezeAmount () {
			return typeFreezeAmount;
		}

		public void setFreezeMemo (String freezeMemo) {
			this.freezeMemo = freezeMemo;
		}

		public String getFreezeMemo () {
			return freezeMemo;
		}

		public void setBeyondOrderNo (String beyondOrderNo) {
			this.beyondOrderNo = beyondOrderNo;
		}

		public String getBeyondOrderNo () {
			return beyondOrderNo;
		}

		public void setTransTime (Date transTime) {
			this.transTime = transTime;
		}

		public Date getTransTime () {
			return transTime;
		}

		public void setCreateTime (Date createTime) {
			this.createTime = createTime;
		}

		public Date getCreateTime () {
			return createTime;
		}

}
