package com.egfbank.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.egfbank.account.dao.BaseAccountDao;
import com.egfbank.account.dao.EgfAccountDao;
import com.egfbank.account.pojo.EgfAccount;
@Repository
public class EgfAccountDaoImpl extends BaseAccountDao implements EgfAccountDao {

private static final long serialVersionUID = -1L;

	public void insertEgfAccount(EgfAccount egfAccount){
		this.insert("com.egfbank.account.insertEgfAccount", egfAccount);
	}

	public void updateEgfAccount(EgfAccount egfAccount){
		this.update("com.egfbank.account.updateEgfAccount", egfAccount);
	}

	public void deleteEgfAccount(String accountNo){
		this.delete("com.egfbank.account.deleteEgfAccount", accountNo);
	}

	public List<EgfAccount> queryEgfAccountListByWhere(EgfAccount egfAccount){
		return this.queryForList("com.egfbank.account.queryEgfAccountByWhere", egfAccount);
	}

	public List<EgfAccount> queryEgfAccountForUpdate(EgfAccount egfAccount){
		return this.queryForList("com.egfbank.account.queryEgfAccountForUpdate", egfAccount);
	}

}