package com.mq.client2;

import javax.jms.Destination;

public interface ProducerService {
	void sendMessage(Destination destination, final String message);
}
