package com.ztx;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.ztx.credit.report.runner.ICreditReportHtmlRunner;

public class TTT {
	@Autowired
	static ICreditReportHtmlRunner rhr;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml","applicationContext-resources.xml","activeMq-product.xml");
	}
}
