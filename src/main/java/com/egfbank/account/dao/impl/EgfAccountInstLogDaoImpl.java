package com.egfbank.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.egfbank.account.dao.BaseAccountDao;
import com.egfbank.account.dao.EgfAccountInstLogDao;
import com.egfbank.account.pojo.EgfAccountInstLog;
@Repository
public class EgfAccountInstLogDaoImpl extends BaseAccountDao implements EgfAccountInstLogDao {

private static final long serialVersionUID = -1L;

	public void insertEgfAccountInstLog(EgfAccountInstLog egfAccountInstLog){
		this.insert("com.egfbank.account.insertEgfAccountInstLog", egfAccountInstLog);
	}

	public void updateEgfAccountInstLog(EgfAccountInstLog egfAccountInstLog){
		this.update("com.egfbank.account.updateEgfAccountInstLog", egfAccountInstLog);
	}

	public void deleteEgfAccountInstLog(String instAccountLogId){
		this.delete("com.egfbank.account.deleteEgfAccountInstLog", instAccountLogId);
	}

	public List<EgfAccountInstLog> queryEgfAccountInstLogListByWhere(EgfAccountInstLog egfAccountInstLog){
		return this.queryForList("com.egfbank.account.queryEgfAccountInstLogByWhere", egfAccountInstLog);
	}

	public List<EgfAccountInstLog> queryEgfAccountInstLogForUpdate(EgfAccountInstLog egfAccountInstLog){
		return this.queryForList("com.egfbank.account.queryEgfAccountInstLogForUpate", egfAccountInstLog);
	}

}