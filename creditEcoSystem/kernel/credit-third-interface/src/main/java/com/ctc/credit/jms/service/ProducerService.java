package com.ctc.credit.jms.service;

import javax.jms.Destination;


public interface ProducerService {
	
	/**
	 * 发送消息
	 * 
	 * @param destination
	 * @param message
	 */
	public void sendMessage(Destination destination,String message);
}
