package com.egfbank.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.egfbank.account.dao.BaseAccountDao;
import com.egfbank.account.dao.EgfAccountLogDao;
import com.egfbank.account.pojo.EgfAccountLog;
@Repository
public class EgfAccountLogDaoImpl extends BaseAccountDao implements EgfAccountLogDao {

private static final long serialVersionUID = -1L;

	public void insertEgfAccountLog(EgfAccountLog egfAccountLog){
		this.insert("com.egfbank.account.insertEgfAccountLog", egfAccountLog);
	}

	public void updateEgfAccountLog(EgfAccountLog egfAccountLog){
		this.update("com.egfbank.account.updateEgfAccountLog", egfAccountLog);
	}

	public void deleteEgfAccountLog(String accountLogId){
		this.delete("com.egfbank.account.deleteEgfAccountLog", accountLogId);
	}

	public List<EgfAccountLog> queryEgfAccountLogListByWhere(EgfAccountLog egfAccountLog){
		return this.queryForList("com.egfbank.account.queryEgfAccountLogByWhere", egfAccountLog);
	}

	public List<EgfAccountLog> queryEgfAccountLogForUpdate(EgfAccountLog egfAccountLog){
		return this.queryForList("com.egfbank.account.queryEgfAccountLogForUpate", egfAccountLog);
	}

}