package com.ctc.credit.lakala.service;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.kernel.util.HttpClientUtil;
import com.ctc.credit.qianhai.constant.QianHaiEnum;

public class JsonRequestHttpClient {
	private static Logger logger = Logger
			.getLogger(JsonRequestHttpClient.class);
	
	public String doPostRequest(String postUrl,String json) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException{
		String reString = null;
		
		CloseableHttpClient httpclient = HttpClientUtil.getHttpClient();

		try {
			HttpPost httpPost = new HttpPost(postUrl);
			logger.info("Request Json Data: "+json);
			StringEntity stringEntity = new StringEntity(json,
					ConfigsContant.UTF_8);// 解决中文乱码问题
			stringEntity.setContentEncoding(ConfigsContant.UTF_8);
			stringEntity.setContentType("application/json");
			httpPost.setEntity(stringEntity);
			RequestConfig.Builder builder = RequestConfig.custom();
			builder.setSocketTimeout(1500);//响应超时
			builder.setConnectionRequestTimeout(15000);
			builder.setConnectTimeout(15000);//连接超时
			httpPost.setConfig(builder.build());
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				reString = EntityUtils.toString(entity,"utf-8");
				logger.info("Reponse Json Data: "+reString);
			} finally {
				response.close();
			}
		}catch(ConnectTimeoutException connectTimeoutException){//请求超时异常
			logger.error("http post throw ConnectTimeoutException", connectTimeoutException);
			throw new RuntimeException(QianHaiEnum.EXC_CODE_A0000+"||ConnectTimeoutException",connectTimeoutException);
		}catch(SocketTimeoutException socketTimeoutException){//响应超时异常
			logger.error("http post throw SocketTimeoutException", socketTimeoutException);
			throw new RuntimeException(QianHaiEnum.EXC_CODE_A0001+"||SocketTimeoutException",socketTimeoutException);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(QianHaiEnum.EXC_CODE_A0002+"||"+ConfigsContant.QIANHAI_REQUEST_URL+"请求异常",e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return reString;
	}
}
