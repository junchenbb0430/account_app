package com.egfbank.account.dao;

import java.io.Serializable;
import java.util.List;
import com.egfbank.account.pojo.EgfAccountFreeze;
public interface EgfAccountFreezeDao extends Serializable {

	public void insertEgfAccountFreeze(EgfAccountFreeze egfAccountFreeze);

	public void updateEgfAccountFreeze(EgfAccountFreeze egfAccountFreeze);

	public void deleteEgfAccountFreeze(String freezeId);

	public List<EgfAccountFreeze> queryEgfAccountFreezeListByWhere(EgfAccountFreeze egfAccountFreeze);

	public List<EgfAccountFreeze> queryEgfAccountFreezeForUpdate(EgfAccountFreeze egfAccountFreeze);

}