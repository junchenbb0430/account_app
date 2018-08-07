package com.egfbank.framework.kafka.consumer.biz;

import com.egfbank.framework.kafka.message.EgfBankMessage;

public interface AccountMessageService<K,V> {

	public String handleAccountMessage(EgfBankMessage<K,V> egfBankMessage);
}
