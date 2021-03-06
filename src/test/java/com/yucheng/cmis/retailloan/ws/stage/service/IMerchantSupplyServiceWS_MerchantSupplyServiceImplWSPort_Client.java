
package com.yucheng.cmis.retailloan.ws.stage.service;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import com.yucheng.cmis.retailloan.ws.stage.service.impl.MerchantSupplyServiceWS;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.16
 * 2018-07-11T18:45:20.282+08:00
 * Generated source version: 3.1.16
 * 
 */
public final class IMerchantSupplyServiceWS_MerchantSupplyServiceImplWSPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.service.stage.ws.retailloan.cmis.yucheng.com/", "MerchantSupplyServiceWS");

    private IMerchantSupplyServiceWS_MerchantSupplyServiceImplWSPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = MerchantSupplyServiceWS.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        MerchantSupplyServiceWS ss = new MerchantSupplyServiceWS(wsdlURL, SERVICE_NAME);
        IMerchantSupplyServiceWS port = ss.getMerchantSupplyServiceImplWSPort();  
      
        
        System.out.println("Invoking queryMerchantStageStatus...");
        java.lang.String _queryMerchantStageStatus_statusInfo = "<?xml version=\"1.0\" encoding=\"utf-8\"?><RequestTrad><RequestHeader><RequestID>ZYAPP20180712100900</RequestID><ChannelType>ZYAPP</ChannelType><RequestDateTime>2018-07-12 10:09:00</RequestDateTime><RequestCode>StateQueryIntf</RequestCode></RequestHeader><ApplyInfo><Mechan_Name></Mechan_Name><State></State><SALE_Manager_No>10550507</SALE_Manager_No></ApplyInfo></RequestTrad>";
        
      try {
          java.lang.String _queryMerchantStageStatus__return = port.queryMerchantStageStatus(_queryMerchantStageStatus_statusInfo);
          System.out.println("queryMerchantStageStatus.result=" + _queryMerchantStageStatus__return);

      } catch (Exception_Exception e) { 
          System.out.println("Expected exception: Exception has occurred.");
          System.out.println(e.toString());
      }
        
        
        
//      System.out.println("Invoking merchantQuery...");
//      java.lang.String _merchantQuery_queryData = "<?xml version=\"1.0\" encoding=\"utf-8\"?><RequestTrad><RequestHeader><RequestID>ZYAPP20180712100900</RequestID><ChannelType>ZYAPP</ChannelType><RequestDateTime>2018-07-12 10:09:00</RequestDateTime><RequestCode>StateQueryIntf</RequestCode></RequestHeader><ApplyInfo><Mechan_Name></Mechan_Name><State></State><SALE_Manager_No>10550507</SALE_Manager_No></ApplyInfo></RequestTrad>";
//      try {
//          java.lang.String _merchantQuery__return = port.merchantQuery(_merchantQuery_queryData);
//          System.out.println("merchantQuery.result=" + _merchantQuery__return);
//
//      } catch (Exception_Exception e) { 
//          System.out.println("Expected exception: Exception has occurred.");
//          System.out.println(e.toString());
//      }
        
        
//        System.out.println("Invoking merchantApply...");
//        java.lang.String _merchantApply_applyData = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <RequestTrad>    <RequestHeader>                 <RequestID>ZYAPP20180711152406</RequestID>              <ChannelType>ZYAPP</ChannelType><RequestDateTime>2018-07-11 15:24:06</RequestDateTime><RequestCode>MechanApply</RequestCode>  </RequestHeader> <Search><Appl_Num>MZR201807150645</Appl_Num><Unique_Code>400024</Unique_Code><division>00160700</division><Mechan_Name>家装商户</Mechan_Name><code>信用代码</code><Zb_Relation>01</Zb_Relation><Zb_Of>01</Zb_Of><IndustryType>01</IndustryType><Sub_Industry>JZJZ,JZCS,CSWDJZ,kkk,CSJZZZ</Sub_Industry><Reg_Addr_Province>230000</Reg_Addr_Province><Reg_Addr_City>230100</Reg_Addr_City><Reg_Addr_District>230102</Reg_Addr_District><Reg_Detail_Addr>注册详细地址</Reg_Detail_Addr><Reg_Capi>注册资本</Reg_Capi><Reg_Tm>2018-07-11</Reg_Tm><Office_Province>220000</Office_Province><Office_City>220200</Office_City><Office_District>220281</Office_District><Office_Detail_Addr>办公地址</Office_Detail_Addr><Exhih_Province>220000</Exhih_Province><Exhih_City>220200</Exhih_City><Exhih_District>220221</Exhih_District><Exhih_Detail_Addr>展厅详细地址</Exhih_Detail_Addr><Busi_Area>555.66</Busi_Area><Operat_Mode>02</Operat_Mode><Decor_Type>01,02,03,04</Decor_Type><Quacer>HAVE</Quacer><Cer_Name>资质等级证书</Cer_Name><Cooper_Compan>已合作分期机构</Cooper_Compan><Cooper_Time>5555</Cooper_Time><Corpor_Web>www.baidu.com</Corpor_Web><Unit_Phone_Qh>010</Unit_Phone_Qh><Unit_Phone_Hm>5269553</Unit_Phone_Hm><Unit_Phone_Zj>34342433343</Unit_Phone_Zj><WORK_AREA>555.66</WORK_AREA><CLASS_NUM></CLASS_NUM><MECHAN_BG></MECHAN_BG><WHET_LIS></WHET_LIS><COOPER_COMPAN_NUM></COOPER_COMPAN_NUM><QUALIF_CERT></QUALIF_CERT><PRI_PER></PRI_PER><WHET_CAM></WHET_CAM><CAMPUS_OPERAT_MODE></CAMPUS_OPERAT_MODE><CAMPUS_DISTRICT></CAMPUS_DISTRICT><CAM_NUM></CAM_NUM><ADMI_METH></ADMI_METH><WHET_OS></WHET_OS></Search><ClopersInfo><Lepe_Name>法人姓名</Lepe_Name><Doc_Type>01</Doc_Type><Id_No>110105198303050125</Id_No><Dura_Bus>555</Dura_Bus><Office_Num>500</Office_Num><Design>200</Design><Foreman>50</Foreman><Freedt>30</Freedt><Outdt>60</Outdt><Pers_Note></Pers_Note><Mana_Quali></Mana_Quali><Ftm_Tea_Num></Ftm_Tea_Num><Par_Tea_Num></Par_Tea_Num><Tea_Src></Tea_Src><Biz_Over></Biz_Over></ClopersInfo> <ClobizInfo><CURRLQ>1111</CURRLQ><ANNUAO>5555</ANNUAO><HOQANT>666</HOQANT><OFFSMO>555</OFFSMO><MONTSO>8888</MONTSO><AVECUP>555.55</AVECUP></ClobizInfo><DockingInfos><DockingInfo><Name>哦哦</Name><Mobile_Phone>15866669999</Mobile_Phone><Email>游戏</Email></DockingInfo></DockingInfos><ContactInfos><ContactInfo><Contact_Type>01</Contact_Type><Name>我现在</Name><Mobile_Phone>13588889999</Mobile_Phone></ContactInfo></ContactInfos><AccountInfos><AccountInfo><Acc_Type>01</Acc_Type><Id_Type>02</Id_Type><Id_No>558866</Id_No><Oppen_Acc>农业银行</Oppen_Acc><Phone>15822223333</Phone><Clear_Acc>5589666</Clear_Acc><Acc_Bank>ABC</Acc_Bank><Branch_Bank>103100025122</Branch_Bank><Province>220000</Province><City>220200</City><District>220204</District><Detail_Addr>开空调</Detail_Addr><Loan_Account>N</Loan_Account></AccountInfo></AccountInfos><CooperInfo><SALE_Manager_Store>00160700</SALE_Manager_Store><SALE_Manager_Group>00160701</SALE_Manager_Group><SALE_Manager_Name>对接SHR-分期渠道-初级BD</SALE_Manager_Name><SALE_Manager_No>10550511</SALE_Manager_No><SALE_Manager_Tel>1223</SALE_Manager_Tel><SALE_Manager_Email></SALE_Manager_Email><Busi_Manager_Store>00020200</Busi_Manager_Store><Busi_Manager_Name>zhaoyunxia-pxb</Busi_Manager_Name><Busi_Manager_No>00020200</Busi_Manager_No><Busi_Manager_Tel>13522838247</Busi_Manager_Tel><Busi_Manager_Email>zhaoyunxia-pxb@sinosig.com</Busi_Manager_Email></CooperInfo></RequestTrad>";
//        try {
//            java.lang.String _merchantApply__return = port.merchantApply(_merchantApply_applyData);
//            System.out.println("merchantApply.result=" + _merchantApply__return);
//
//        } catch (Exception_Exception e) { 
//            System.out.println("Expected exception: Exception has occurred.");
//            System.out.println(e.toString());
//        }

        
        System.out.println("Invoking merchantModify...");
//        java.lang.String _merchantModify_modifyData = "<?xml version=\"1.0\" encoding=\"utf-8\"?> <RequestTrad>    <RequestHeader>                 <RequestID>ZYAPP20180711152406</RequestID>              <ChannelType>ZYAPP</ChannelType><RequestDateTime>2018-07-11 15:24:06</RequestDateTime><RequestCode>MechanApply</RequestCode>  </RequestHeader> <Search><Appl_Num>MZR201807140343</Appl_Num><Unique_Code>400024</Unique_Code><division>00160700</division><Mechan_Name>家装商户</Mechan_Name><code>信用代码</code><Zb_Relation>01</Zb_Relation><Zb_Of>01</Zb_Of><IndustryType>01</IndustryType><Sub_Industry>JZJZ,JZCS,CSWDJZ,kkk,CSJZZZ</Sub_Industry><Reg_Addr_Province>230000</Reg_Addr_Province><Reg_Addr_City>230100</Reg_Addr_City><Reg_Addr_District>230102</Reg_Addr_District><Reg_Detail_Addr>注册详细地址</Reg_Detail_Addr><Reg_Capi>注册资本</Reg_Capi><Reg_Tm>2018-07-11</Reg_Tm><Office_Province>220000</Office_Province><Office_City>220200</Office_City><Office_District>220281</Office_District><Office_Detail_Addr>办公地址</Office_Detail_Addr><Exhih_Province>220000</Exhih_Province><Exhih_City>220200</Exhih_City><Exhih_District>220221</Exhih_District><Exhih_Detail_Addr>展厅详细地址</Exhih_Detail_Addr><Busi_Area>555.66</Busi_Area><Operat_Mode>02</Operat_Mode><Decor_Type>01,02,03,04</Decor_Type><Quacer>HAVE</Quacer><Cer_Name>资质等级证书</Cer_Name><Cooper_Compan>已合作分期机构</Cooper_Compan><Cooper_Time>5555</Cooper_Time><Corpor_Web>www.baidu.com</Corpor_Web><Unit_Phone_Qh>010</Unit_Phone_Qh><Unit_Phone_Hm>5269553</Unit_Phone_Hm><Unit_Phone_Zj>34342433343</Unit_Phone_Zj><WORK_AREA>555.66</WORK_AREA><CLASS_NUM></CLASS_NUM><MECHAN_BG></MECHAN_BG><WHET_LIS></WHET_LIS><COOPER_COMPAN_NUM></COOPER_COMPAN_NUM><QUALIF_CERT></QUALIF_CERT><PRI_PER></PRI_PER><WHET_CAM></WHET_CAM><CAMPUS_OPERAT_MODE></CAMPUS_OPERAT_MODE><CAMPUS_DISTRICT></CAMPUS_DISTRICT><CAM_NUM></CAM_NUM><ADMI_METH></ADMI_METH><WHET_OS></WHET_OS></Search><ClopersInfo><Lepe_Name>法人姓名</Lepe_Name><Doc_Type>01</Doc_Type><Id_No>110105198303050125</Id_No><Dura_Bus>555</Dura_Bus><Office_Num>500</Office_Num><Design>200</Design><Foreman>50</Foreman><Freedt>30</Freedt><Outdt>60</Outdt><Pers_Note></Pers_Note><Mana_Quali></Mana_Quali><Ftm_Tea_Num></Ftm_Tea_Num><Par_Tea_Num></Par_Tea_Num><Tea_Src></Tea_Src><Biz_Over></Biz_Over></ClopersInfo> <ClobizInfo><CURRLQ>1111</CURRLQ><ANNUAO>5555</ANNUAO><HOQANT>666</HOQANT><OFFSMO>555</OFFSMO><MONTSO>8888</MONTSO><AVECUP>555.55</AVECUP></ClobizInfo><DockingInfos><DockingInfo><Name>哦哦</Name><Mobile_Phone>15866669999</Mobile_Phone><Email>游戏</Email></DockingInfo></DockingInfos><ContactInfos><ContactInfo><Contact_Type>01</Contact_Type><Name>我现在</Name><Mobile_Phone>13588889999</Mobile_Phone></ContactInfo></ContactInfos><AccountInfos><AccountInfo><Acc_Type>01</Acc_Type><Id_Type>02</Id_Type><Id_No>558866</Id_No><Oppen_Acc>农业银行</Oppen_Acc><Phone>15822223333</Phone><Clear_Acc>5589666</Clear_Acc><Acc_Bank>ABC</Acc_Bank><Branch_Bank>103100025122</Branch_Bank><Province>220000</Province><City>220200</City><District>220204</District><Detail_Addr>开空调</Detail_Addr><Loan_Account>N</Loan_Account></AccountInfo></AccountInfos></RequestTrad>";
//        
//       
//      try {
//          java.lang.String _merchantModify__return = port.merchantModify(_merchantModify_modifyData);
//          System.out.println("merchantModify.result=" + _merchantModify__return);
//
//      } catch (Exception_Exception e) { 
//          System.out.println("Expected exception: Exception has occurred.");
//          System.out.println(e.toString());
//      }
        
        
        
        
        //        {
//        System.out.println("Invoking merchantReSubmit...");
//        java.lang.String _merchantReSubmit_reSubmitData = "";
//        try {
//            java.lang.String _merchantReSubmit__return = port.merchantReSubmit(_merchantReSubmit_reSubmitData);
//            System.out.println("merchantReSubmit.result=" + _merchantReSubmit__return);
//
//        } catch (Exception_Exception e) { 
//            System.out.println("Expected exception: Exception has occurred.");
//            System.out.println(e.toString());
//        }
//            }
//        {
//        System.out.println("Invoking merchantModify...");
//        java.lang.String _merchantModify_modifyData = "";
//        try {
//            java.lang.String _merchantModify__return = port.merchantModify(_merchantModify_modifyData);
//            System.out.println("merchantModify.result=" + _merchantModify__return);
//
//        } catch (Exception_Exception e) { 
//            System.out.println("Expected exception: Exception has occurred.");
//            System.out.println(e.toString());
//        }
//            }
//        {
//        System.out.println("Invoking merchantQuery...");
//        java.lang.String _merchantQuery_queryData = "";
//        try {
//            java.lang.String _merchantQuery__return = port.merchantQuery(_merchantQuery_queryData);
//            System.out.println("merchantQuery.result=" + _merchantQuery__return);
//
//        } catch (Exception_Exception e) { 
//            System.out.println("Expected exception: Exception has occurred.");
//            System.out.println(e.toString());
//        }
//            }
//        {
//        System.out.println("Invoking queryMerchantStageStatus...");
//        java.lang.String _queryMerchantStageStatus_statusInfo = "";
//        try {
//            java.lang.String _queryMerchantStageStatus__return = port.queryMerchantStageStatus(_queryMerchantStageStatus_statusInfo);
//            System.out.println("queryMerchantStageStatus.result=" + _queryMerchantStageStatus__return);
//
//        } catch (Exception_Exception e) { 
//            System.out.println("Expected exception: Exception has occurred.");
//            System.out.println(e.toString());
//        }
//            }
//        {
//      
//            }

        System.exit(0);
    }

}
