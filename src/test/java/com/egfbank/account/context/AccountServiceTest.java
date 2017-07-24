package com.egfbank.account.context;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.egfbank.account.request.BaseAccount;
import com.egfbank.account.service.AccountService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring-context.xml")
public class AccountServiceTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired	
	private AccountService accoutService;
	
	@Test
	public void testOpenAccount(){
		BaseAccount baseAccount = new BaseAccount();
		baseAccount.setDepositAmount(new BigDecimal(0));
		baseAccount.setAccountDirection("C");
		baseAccount.setBalance(new BigDecimal(0));
		baseAccount.setAccountTitle("消费账户");
		baseAccount.setFreezeAmount(new BigDecimal(0));
		baseAccount.setStatus("S");
		String accountNo = accoutService.openAccount(baseAccount);
		System.out.println(accountNo);
	}
}
