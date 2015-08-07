package com.ctc.credit.blackgreylist.taskJob;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.service.IInternalData;
import com.ctc.credit.constant.ConfigsContant;


@Component
public class CreateInterDataTaskJob {
	@Autowired
	IInternalData interData;
	
	private Logger log = Logger.getLogger("D");
	
	@Scheduled(cron = "0 15 13 ? * *" ) 
	public void job(){
		InputStream input = null;
		Properties prop = new Properties();
		input = ConfigsContant.class.getClassLoader().getResourceAsStream("task_job.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			log.equals(e.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				input = null;
				e.printStackTrace();
			}
		}
		
		if("1".equals(prop.getProperty("create_inter_data_task_job_run"))){
			log.info("开始执行黑灰名单跑批程序");
			try{
				Date today = new Date();
				Long t = today.getTime();
				int bs = interData.createInternalBadCustomers();
				int gs = interData.createRiskCustomerInfo();
				today = new Date();
				log.info(">>>>黑名单跑批完成 新增黑名单:"+bs +"  新增灰名单:"+gs + " 共用时:"+((t-today.getTime())/1000)+"秒");
			}catch(Exception ex){
				log.info("黑灰名单跑批异常");
			}
		}
	}
}
