
package com.yucheng.cmis.retailloan.ws.stage.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yucheng.cmis.retailloan.ws.stage.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MerchantApply_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantApply");
    private final static QName _MerchantApplyResponse_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantApplyResponse");
    private final static QName _MerchantModify_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantModify");
    private final static QName _MerchantModifyResponse_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantModifyResponse");
    private final static QName _MerchantQuery_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantQuery");
    private final static QName _MerchantQueryResponse_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantQueryResponse");
    private final static QName _MerchantReSubmit_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantReSubmit");
    private final static QName _MerchantReSubmitResponse_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "merchantReSubmitResponse");
    private final static QName _QueryMerchantStageStatus_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "queryMerchantStageStatus");
    private final static QName _QueryMerchantStageStatusResponse_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "queryMerchantStageStatusResponse");
    private final static QName _Exception_QNAME = new QName("http://service.stage.ws.retailloan.cmis.yucheng.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yucheng.cmis.retailloan.ws.stage.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MerchantApply }
     * 
     */
    public MerchantApply createMerchantApply() {
        return new MerchantApply();
    }

    /**
     * Create an instance of {@link MerchantApplyResponse }
     * 
     */
    public MerchantApplyResponse createMerchantApplyResponse() {
        return new MerchantApplyResponse();
    }

    /**
     * Create an instance of {@link MerchantModify }
     * 
     */
    public MerchantModify createMerchantModify() {
        return new MerchantModify();
    }

    /**
     * Create an instance of {@link MerchantModifyResponse }
     * 
     */
    public MerchantModifyResponse createMerchantModifyResponse() {
        return new MerchantModifyResponse();
    }

    /**
     * Create an instance of {@link MerchantQuery }
     * 
     */
    public MerchantQuery createMerchantQuery() {
        return new MerchantQuery();
    }

    /**
     * Create an instance of {@link MerchantQueryResponse }
     * 
     */
    public MerchantQueryResponse createMerchantQueryResponse() {
        return new MerchantQueryResponse();
    }

    /**
     * Create an instance of {@link MerchantReSubmit }
     * 
     */
    public MerchantReSubmit createMerchantReSubmit() {
        return new MerchantReSubmit();
    }

    /**
     * Create an instance of {@link MerchantReSubmitResponse }
     * 
     */
    public MerchantReSubmitResponse createMerchantReSubmitResponse() {
        return new MerchantReSubmitResponse();
    }

    /**
     * Create an instance of {@link QueryMerchantStageStatus }
     * 
     */
    public QueryMerchantStageStatus createQueryMerchantStageStatus() {
        return new QueryMerchantStageStatus();
    }

    /**
     * Create an instance of {@link QueryMerchantStageStatusResponse }
     * 
     */
    public QueryMerchantStageStatusResponse createQueryMerchantStageStatusResponse() {
        return new QueryMerchantStageStatusResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantApply }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantApply")
    public JAXBElement<MerchantApply> createMerchantApply(MerchantApply value) {
        return new JAXBElement<MerchantApply>(_MerchantApply_QNAME, MerchantApply.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantApplyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantApplyResponse")
    public JAXBElement<MerchantApplyResponse> createMerchantApplyResponse(MerchantApplyResponse value) {
        return new JAXBElement<MerchantApplyResponse>(_MerchantApplyResponse_QNAME, MerchantApplyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantModify }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantModify")
    public JAXBElement<MerchantModify> createMerchantModify(MerchantModify value) {
        return new JAXBElement<MerchantModify>(_MerchantModify_QNAME, MerchantModify.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantModifyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantModifyResponse")
    public JAXBElement<MerchantModifyResponse> createMerchantModifyResponse(MerchantModifyResponse value) {
        return new JAXBElement<MerchantModifyResponse>(_MerchantModifyResponse_QNAME, MerchantModifyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantQuery }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantQuery")
    public JAXBElement<MerchantQuery> createMerchantQuery(MerchantQuery value) {
        return new JAXBElement<MerchantQuery>(_MerchantQuery_QNAME, MerchantQuery.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantQueryResponse")
    public JAXBElement<MerchantQueryResponse> createMerchantQueryResponse(MerchantQueryResponse value) {
        return new JAXBElement<MerchantQueryResponse>(_MerchantQueryResponse_QNAME, MerchantQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantReSubmit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantReSubmit")
    public JAXBElement<MerchantReSubmit> createMerchantReSubmit(MerchantReSubmit value) {
        return new JAXBElement<MerchantReSubmit>(_MerchantReSubmit_QNAME, MerchantReSubmit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MerchantReSubmitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "merchantReSubmitResponse")
    public JAXBElement<MerchantReSubmitResponse> createMerchantReSubmitResponse(MerchantReSubmitResponse value) {
        return new JAXBElement<MerchantReSubmitResponse>(_MerchantReSubmitResponse_QNAME, MerchantReSubmitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryMerchantStageStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "queryMerchantStageStatus")
    public JAXBElement<QueryMerchantStageStatus> createQueryMerchantStageStatus(QueryMerchantStageStatus value) {
        return new JAXBElement<QueryMerchantStageStatus>(_QueryMerchantStageStatus_QNAME, QueryMerchantStageStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryMerchantStageStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "queryMerchantStageStatusResponse")
    public JAXBElement<QueryMerchantStageStatusResponse> createQueryMerchantStageStatusResponse(QueryMerchantStageStatusResponse value) {
        return new JAXBElement<QueryMerchantStageStatusResponse>(_QueryMerchantStageStatusResponse_QNAME, QueryMerchantStageStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.stage.ws.retailloan.cmis.yucheng.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
