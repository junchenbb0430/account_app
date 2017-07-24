package com.egfbank.account.dao;

import java.io.Serializable;
import java.util.List;
import com.egfbank.account.pojo.EgfAccountFreezeLog;
public interface EgfAccountFreezeLogDao extends Serializable {

	public void insertEgfAccountFreezeLog(EgfAccountFreezeLog egfAccountFreezeLog);

	public void updateEgfAccountFreezeLog(EgfAccountFreezeLog egfAccountFreezeLog);

	public void deleteEgfAccountFreezeLog(String freezeIdLog);

	public List<EgfAccountFreezeLog> queryEgfAccountFreezeLogListByWhere(EgfAccountFreezeLog egfAccountFreezeLog);

	public List<EgfAccountFreezeLog> queryEgfAccountFreezeLogForUpdate(EgfAccountFreezeLog egfAccountFreezeLog);

}