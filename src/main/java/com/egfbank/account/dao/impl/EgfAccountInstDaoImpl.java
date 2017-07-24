package com.egfbank.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.egfbank.account.dao.BaseAccountDao;
import com.egfbank.account.dao.EgfAccountInstDao;
import com.egfbank.account.pojo.EgfAccountInst;
@Repository
public class EgfAccountInstDaoImpl extends BaseAccountDao implements EgfAccountInstDao {

private static final long serialVersionUID = -1L;

	public void insertEgfAccountInst(EgfAccountInst egfAccountInst){
		this.insert("com.egfbank.account.insertEgfAccountInst", egfAccountInst);
	}

	public void updateEgfAccountInst(EgfAccountInst egfAccountInst){
		this.update("com.egfbank.account.updateEgfAccountInst", egfAccountInst);
	}

	public void deleteEgfAccountInst(String instAccountNo){
		this.delete("com.egfbank.account.deleteEgfAccountInst", instAccountNo);
	}

	public List<EgfAccountInst> queryEgfAccountInstListByWhere(EgfAccountInst egfAccountInst){
		return this.queryForList("com.egfbank.account.queryEgfAccountInstByWhere", egfAccountInst);
	}

	public List<EgfAccountInst> queryEgfAccountInstForUpdate(EgfAccountInst egfAccountInst){
		return this.queryForList("com.egfbank.account.queryEgfAccountInstForUpate", egfAccountInst);
	}

}