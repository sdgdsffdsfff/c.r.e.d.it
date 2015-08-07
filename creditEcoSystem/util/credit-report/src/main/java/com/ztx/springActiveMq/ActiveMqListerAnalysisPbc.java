package com.ztx.springActiveMq;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.xerces.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.ztx.credit.report.runner.ICreditReportHtmlRunner;

@Component("analysisPbcMessageHandler")
@Scope("prototype")
public class ActiveMqListerAnalysisPbc implements SessionAwareMessageListener<TextMessage>{
	
	@Autowired
	ICreditReportHtmlRunner rhr;
	
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		String text = message.getText();
		rhr.setHtmlDriverUrl("http://localhost:8080/credit-readPbc/getPbc.action?id="+text);
		rhr.getPersonCreditInfo();
		
//		ThreadPoolExecutor pool= TaskPoolFactory.getTaskPool(3, 15, 1, 20);
//		int x  = 0;
//		while(true){
//			x = pool.getQueue().size();
//			if(x >= 5){
//				try {
//					Thread.sleep(500L);
//					System.out.println("=====沉睡"+sleep++);
//					continue;
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//			break;
//		}
//		sleep = 0;
//		System.out.println("====加入一个线程====="+thread+"====队列线程"+x+"==========="+pool.getActiveCount());
//		thread++;
//			String text = message.getText();
//			rhr.setHtmlDriverUrl("http://localhost:8080/credit-readPbc/getPbc.action?id="+text);
//			pool.execute(rhr);
//			break;
//		}
//		
//        String text = message.getText();  
//        rhr.setHtmlDriverUrl("http://localhost:8080/credit-readPbc/getPbc.action?id="+text);
//        System.out.println("=======开始解析报告:"+text);
//        rhr.getPersonCreditInfo();
	}

}
