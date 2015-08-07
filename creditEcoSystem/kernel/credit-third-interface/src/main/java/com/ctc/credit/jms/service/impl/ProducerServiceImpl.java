package com.ctc.credit.jms.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.ctc.credit.jms.service.ProducerService;

@Component
public class ProducerServiceImpl implements ProducerService {

	@Resource(name="jmsTemplate")
	private JmsTemplate jmsTemplate;  
	
	private static Logger logger = Logger.getLogger(ProducerServiceImpl.class);
	
	@Override
	public void sendMessage(Destination destination, final String message) {
		logger.info("----------------生产者发送消息开始----------------");  
		logger.info("----------------生产者发送了一个消息：" + message);  
        jmsTemplate.send(destination, new MessageCreator(){
			@Override
			public Message createMessage(Session session)
					throws JMSException {
				return session.createTextMessage(message);
			}
        	
        });
        logger.info("----------------生产者发送消息结束----------------");  
	}

}
