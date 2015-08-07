package com.ctc.credit.kernel;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.kernel.base.CodeGenerate;


public class TEST {

	public static void main(String[] args) throws Exception {
////		CodeGenerate.genCode(CisTelCheckInfo.class);
//		CodeGenerate.genCode(CreditBlkgraylistDetailEntity.class);
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://www.baidu.com");
		HttpResponse httpResponse = client.execute(get);
		HttpEntity entity = httpResponse.getEntity();
		System.out.println("响应状态" + httpResponse.getStatusLine());
		if(entity != null){
			System.out.println("响应长度" + entity.getContentLength());
		}
	}
}
