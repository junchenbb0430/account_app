package com.egfbank.account.context;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.egfbank.account.pojo.EgfAccount;
import com.egfbank.account.sequence.SequenceGenerateService;
import com.egfbank.account.service.AccountService;
import com.egfbank.account.service.impl.AccountServiceImpl;

public class SpringContextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configXml ="classpath:config/spring-context.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configXml);
		TransactionTemplate transaction = context.getBean(TransactionTemplate.class);
		System.out.println(context.getBean("sqlSessionFactory"));
		DataSourceTransactionManager transactionManager = context.getBean(DataSourceTransactionManager.class);
		try {
			Connection conn = transactionManager.getDataSource().getConnection();
			System.out.println(conn);
			SequenceGenerateService sequenceService = context.getBean(SequenceGenerateService.class);
			final AccountService accountService = context.getBean(AccountServiceImpl.class); 
			transaction.execute(new TransactionCallback(){

				public Object doInTransaction(TransactionStatus status) {
					EgfAccount account= new EgfAccount();
					account.setAccountNo("201701120000000422");
					//accountService.freezeAccount(account);
					try {
						Thread.sleep(1000*40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
				
			});
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
