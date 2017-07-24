package com.egfbank.account.dao;

import java.io.Serializable;
import java.util.List;
import com.egfbank.account.pojo.EgfAccountLog;
public interface EgfAccountLogDao extends Serializable {

	public void insertEgfAccountLog(EgfAccountLog egfAccountLog);

	public void updateEgfAccountLog(EgfAccountLog egfAccountLog);

	public void deleteEgfAccountLog(String accountLogId);

	public List<EgfAccountLog> queryEgfAccountLogListByWhere(EgfAccountLog egfAccountLog);

	public List<EgfAccountLog> queryEgfAccountLogForUpdate(EgfAccountLog egfAccountLog);

}