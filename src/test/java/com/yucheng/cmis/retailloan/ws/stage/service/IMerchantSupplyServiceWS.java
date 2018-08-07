package com.yucheng.cmis.retailloan.ws.stage.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.16
 * 2018-07-11T18:45:20.376+08:00
 * Generated source version: 3.1.16
 * 
 */
@WebService(targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "IMerchantSupplyServiceWS")
@XmlSeeAlso({ObjectFactory.class})
public interface IMerchantSupplyServiceWS {

    @WebMethod
    @RequestWrapper(localName = "merchantReSubmit", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantReSubmit")
    @ResponseWrapper(localName = "merchantReSubmitResponse", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantReSubmitResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String merchantReSubmit(
        @WebParam(name = "reSubmitData", targetNamespace = "")
        java.lang.String reSubmitData
    ) throws Exception_Exception;

    @WebMethod
    @RequestWrapper(localName = "merchantModify", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantModify")
    @ResponseWrapper(localName = "merchantModifyResponse", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantModifyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String merchantModify(
        @WebParam(name = "modifyData", targetNamespace = "")
        java.lang.String modifyData
    ) throws Exception_Exception;

    @WebMethod
    @RequestWrapper(localName = "merchantQuery", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantQuery")
    @ResponseWrapper(localName = "merchantQueryResponse", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantQueryResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String merchantQuery(
        @WebParam(name = "queryData", targetNamespace = "")
        java.lang.String queryData
    ) throws Exception_Exception;

    @WebMethod
    @RequestWrapper(localName = "queryMerchantStageStatus", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.QueryMerchantStageStatus")
    @ResponseWrapper(localName = "queryMerchantStageStatusResponse", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.QueryMerchantStageStatusResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String queryMerchantStageStatus(
        @WebParam(name = "statusInfo", targetNamespace = "")
        java.lang.String statusInfo
    ) throws Exception_Exception;

    @WebMethod
    @RequestWrapper(localName = "merchantApply", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantApply")
    @ResponseWrapper(localName = "merchantApplyResponse", targetNamespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", className = "com.yucheng.cmis.retailloan.ws.stage.service.MerchantApplyResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String merchantApply(
        @WebParam(name = "applyData", targetNamespace = "")
        java.lang.String applyData
    ) throws Exception_Exception;
}
