package com.egfbank.mq.egfenum;

public class EgfEnumTest {

	public static void main(String[] args) {
		EgfEnumTest enumTest = new EgfEnumTest(); 
		
		for(EgfTopicInfoEnum bankEnum:EgfTopicInfoEnum.values()){
			System.out.println("topic-->"+bankEnum.getTopicName()+",tag-->"+bankEnum.getTagName());
		}
		enumTest.judge(EgfTopicInfoEnum.topicTestD);
		
	}
	
	public void judge(EgfTopicInfoEnum egfBank){
		switch(egfBank){
		case topicTestA:
			System.out.println("***topicTestA***");
			break;
		case topicTestB:
			System.out.println("***topicTestB***");
			break;
		case topicTestC:
			System.out.println("***topicTestC****");
			break;
		case topicTestD:
			System.out.println("***topicTestD***");
			break;
		default:
				System.out.println("no match topic");
		}
	}

}
