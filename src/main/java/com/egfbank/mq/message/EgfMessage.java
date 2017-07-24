package com.egfbank.mq.message;

import java.io.Serializable;

/**
 * 
 * @author tonny
 *
 */
public class EgfMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4666704713699252832L;

	/**
	 * 代表一类消息类型
	 */
	private String topicName;
	
	/**
	 * topic下面的tag
	 */
	private String msgTags;
	
	/**
	 * 消息key,请业务保证唯一
	 */
	private String msgKey;
	
	
	/**
	 * 发送消息具体对象
	 */
	private Object obj;

	public EgfMessage(){}
	
	public EgfMessage( String msgKey,
			Object obj) {
		super();
		 
		this.msgKey = msgKey;
		this.obj = obj;
	}

	public EgfMessage( Object obj) {
		super();
		 
		this.obj = obj;
	}
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getMsgTags() {
		return msgTags;
	}

	public void setMsgTags(String msgTags) {
		this.msgTags = msgTags;
	}

	public String getMsgKey() {
		return msgKey;
	}

	public void setMsgKey(String msgKey) {
		this.msgKey = msgKey;
	}
	
	
	
}
