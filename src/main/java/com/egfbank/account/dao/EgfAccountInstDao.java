package com.egfbank.account.dao;

import java.io.Serializable;
import java.util.List;
import com.egfbank.account.pojo.EgfAccountInst;
public interface EgfAccountInstDao extends Serializable {

	public void insertEgfAccountInst(EgfAccountInst egfAccountInst);

	public void updateEgfAccountInst(EgfAccountInst egfAccountInst);

	public void deleteEgfAccountInst(String instAccountNo);

	public List<EgfAccountInst> queryEgfAccountInstListByWhere(EgfAccountInst egfAccountInst);

	public List<EgfAccountInst> queryEgfAccountInstForUpdate(EgfAccountInst egfAccountInst);

}