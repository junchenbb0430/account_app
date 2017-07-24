package com.egfbank.account.dao;

import java.io.Serializable;
import java.util.List;
import com.egfbank.account.pojo.EgfAccount;
public interface EgfAccountDao extends Serializable {

	public void insertEgfAccount(EgfAccount egfAccount);

	public void updateEgfAccount(EgfAccount egfAccount);

	public void deleteEgfAccount(String accountNo);

	public List<EgfAccount> queryEgfAccountListByWhere(EgfAccount egfAccount);

	public List<EgfAccount> queryEgfAccountForUpdate(EgfAccount egfAccount);

}