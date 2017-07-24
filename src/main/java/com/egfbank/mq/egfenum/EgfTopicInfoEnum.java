/**
 * 
 */
package com.egfbank.mq.egfenum;

/**
 * @author tonny
 *
 */
public enum EgfTopicInfoEnum {
	
	topicTestA("topicTestA","tagA"),
	topicTestB("topicTestB","tagB"),
	topicTestC("topicTestC","tagC"),
	topicTestD("topicTestD","tagD"),
	topicTestE("topicTestE","tagE");
	
	private String topicName;
	
	private String tagName;
	
	private EgfTopicInfoEnum(String topic,String tag){
		this.topicName = topic;
		this.tagName = tag;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	
}
