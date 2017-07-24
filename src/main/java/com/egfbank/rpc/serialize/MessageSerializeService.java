package com.egfbank.rpc.serialize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.egfbank.rpc.request.MessageRequest;
import com.egfbank.rpc.response.MessageResponse;

public class MessageSerializeService implements SerializationOptimizer {

	public Collection<Class> getSerializableClasses() {
		 List<Class> classCollection = new ArrayList<Class>();
		 classCollection.add(MessageRequest.class);
		 classCollection.add(MessageResponse.class);
		return classCollection;
	}

}
