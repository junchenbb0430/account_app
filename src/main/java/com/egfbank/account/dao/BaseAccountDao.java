package com.egfbank.account.dao;


import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

 
public class BaseAccountDao extends SqlSessionDaoSupport
{
  @Autowired
  public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate_payment)
  {
    super.setSqlSessionTemplate(sqlSessionTemplate_payment);
  }

  public void insert(String statementName, Object object)
  {
    getSqlSession().insert(statementName, object);
  }

  public void update(String statementName, Object object)
  {
    getSqlSession().update(statementName, object);
  }

  public void delete(String statementName, Object object)
  {
    getSqlSession().delete(statementName, object);
  }

  public <T> T getOne(String statementName, Object object)
  {
    return getSqlSession().selectOne(statementName, object);
  }

  public <T> List<T> queryForList(String statementName)
  {
    return getSqlSession().selectList(statementName);
  }

  public <T> List<T> queryForList(String statementName, Object paramObj)
  {
    return getSqlSession().selectList(statementName, paramObj);
  }
}