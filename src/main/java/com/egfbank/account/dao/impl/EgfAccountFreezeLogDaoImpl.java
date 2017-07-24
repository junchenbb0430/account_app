package com.egfbank.account.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.egfbank.account.dao.BaseAccountDao;
import com.egfbank.account.dao.EgfAccountFreezeLogDao;
import com.egfbank.account.pojo.EgfAccountFreezeLog;
@Repository
public class EgfAccountFreezeLogDaoImpl extends BaseAccountDao implements EgfAccountFreezeLogDao {

private static final long serialVersionUID = -1L;

	public void insertEgfAccountFreezeLog(EgfAccountFreezeLog egfAccountFreezeLog){
		this.insert("com.egfbank.account.insertEgfAccountFreezeLog", egfAccountFreezeLog);
	}

	public void updateEgfAccountFreezeLog(EgfAccountFreezeLog egfAccountFreezeLog){
		this.update("com.egfbank.account.updateEgfAccountFreezeLog", egfAccountFreezeLog);
	}

	public void deleteEgfAccountFreezeLog(String freezeIdLog){
		this.delete("com.egfbank.account.deleteEgfAccountFreezeLog", freezeIdLog);
	}

	public List<EgfAccountFreezeLog> queryEgfAccountFreezeLogListByWhere(EgfAccountFreezeLog egfAccountFreezeLog){
		return this.queryForList("com.egfbank.account.queryEgfAccountFreezeLogByWhere", egfAccountFreezeLog);
	}

	public List<EgfAccountFreezeLog> queryEgfAccountFreezeLogForUpdate(EgfAccountFreezeLog egfAccountFreezeLog){
		return this.queryForList("com.egfbank.account.queryEgfAccountFreezeLogForUpate", egfAccountFreezeLog);
	}

}