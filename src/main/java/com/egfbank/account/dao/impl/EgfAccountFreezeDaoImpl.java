package com.egfbank.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.egfbank.account.dao.BaseAccountDao;
import com.egfbank.account.dao.EgfAccountFreezeDao;
import com.egfbank.account.pojo.EgfAccountFreeze;
@Repository
public class EgfAccountFreezeDaoImpl extends BaseAccountDao implements EgfAccountFreezeDao {

private static final long serialVersionUID = -1L;

	public void insertEgfAccountFreeze(EgfAccountFreeze egfAccountFreeze){
		this.insert("com.egfbank.account.insertEgfAccountFreeze", egfAccountFreeze);
	}

	public void updateEgfAccountFreeze(EgfAccountFreeze egfAccountFreeze){
		this.update("com.egfbank.account.updateEgfAccountFreeze", egfAccountFreeze);
	}

	public void deleteEgfAccountFreeze(String freezeId){
		this.delete("com.egfbank.account.deleteEgfAccountFreeze", freezeId);
	}

	public List<EgfAccountFreeze> queryEgfAccountFreezeListByWhere(EgfAccountFreeze egfAccountFreeze){
		return this.queryForList("com.egfbank.account.queryEgfAccountFreezeByWhere", egfAccountFreeze);
	}

	public List<EgfAccountFreeze> queryEgfAccountFreezeForUpdate(EgfAccountFreeze egfAccountFreeze){
		return this.queryForList("com.egfbank.account.queryEgfAccountFreezeForUpate", egfAccountFreeze);
	}

}