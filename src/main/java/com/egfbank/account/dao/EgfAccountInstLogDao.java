package com.egfbank.account.dao;

import java.io.Serializable;
import java.util.List;
import com.egfbank.account.pojo.EgfAccountInstLog;
public interface EgfAccountInstLogDao extends Serializable {

	public void insertEgfAccountInstLog(EgfAccountInstLog egfAccountInstLog);

	public void updateEgfAccountInstLog(EgfAccountInstLog egfAccountInstLog);

	public void deleteEgfAccountInstLog(String instAccountLogId);

	public List<EgfAccountInstLog> queryEgfAccountInstLogListByWhere(EgfAccountInstLog egfAccountInstLog);

	public List<EgfAccountInstLog> queryEgfAccountInstLogForUpdate(EgfAccountInstLog egfAccountInstLog);

}