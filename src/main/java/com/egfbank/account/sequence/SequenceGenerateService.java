package com.egfbank.account.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;
import org.springframework.stereotype.Component;

import com.egfbank.account.utils.EgfDateUtils;

@Component("sequenceService")
public class SequenceGenerateService {
	
	private final String ACCOUNT_SEQUENCE = "account_sequence";
	
	private final String ACCOUNT_LOG_SEQUENCE = "account_log_sequence";
	
	private final String ACCOUNT_FREEZE_SEQUENCE = "account_freeze_sequence";
	
	private final String ACCOUNT_FREEZE_LOG_SEQUENCE = "account_freeze_log_sequence";
	
	@Autowired
	private MySQLMaxValueIncrementer mysqlMaxValueIncrementer;
	
	public String accountSequenceGenerator(){
		mysqlMaxValueIncrementer.setIncrementerName(ACCOUNT_SEQUENCE);
		return  EgfDateUtils.formateCurrentDate()+mysqlMaxValueIncrementer.nextStringValue();
	}
	
	public String accountLogSequenceGenerator(){
		mysqlMaxValueIncrementer.setIncrementerName(ACCOUNT_LOG_SEQUENCE);
		return  EgfDateUtils.formateCurrentDateTime()+mysqlMaxValueIncrementer.nextStringValue();
	}
	
	public String accountFreezeSequenceGenerator(){
		mysqlMaxValueIncrementer.setIncrementerName(ACCOUNT_FREEZE_SEQUENCE);
		return  EgfDateUtils.formateCurrentDateTime()+mysqlMaxValueIncrementer.nextStringValue();
	}
	
	public String accountFreezeLogSequenceGenerator(){
		mysqlMaxValueIncrementer.setIncrementerName(ACCOUNT_FREEZE_LOG_SEQUENCE);
		return  EgfDateUtils.formateCurrentDateTime()+mysqlMaxValueIncrementer.nextStringValue();
	}
}
