package com.ctc.credit.tongdun.api.service.impl;

import java.net.SocketTimeoutException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDetailDto;
import com.ctc.credit.tongdun.api.service.TongDunDetailByIdService;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailRequest;
@Service
@Transactional
public class TongDunDetailByIdServiceImpl implements TongDunDetailByIdService {
	
	private static Logger logger=Logger.getLogger(TongDunDetailByIdServiceImpl.class);
	
	@Override
	public TongDunResRiskApiDetailDto queryDetailById(HandleTdRiskApiDetailRequest handleTdRiskApiDetailRequest) throws Exception{
		logger.info("------------------TongDun RemoteDetail Request Begin------------------------");
		long start=System.currentTimeMillis();
		SSLConnectionSocketFactory ssl=null;
		CloseableHttpClient httpclient=HttpClients.custom().setSSLSocketFactory(getSsl(ssl)).build();
		
		TongDunResRiskApiDetailDto tongDunDetailResponseDto=new TongDunResRiskApiDetailDto();
		try{
		RequestConfig.Builder builder=RequestConfig.custom();
		builder.setSocketTimeout(10000);//响应超时
		builder.setConnectionRequestTimeout(10000);//连接请求超时
		builder.setConnectTimeout(10000);//连接超时
		URI uri = new URIBuilder()
        .setScheme("http")
        .setHost("portal.fraudmetrix.cn")
        .setPath("/webService/hitRuleDetail")
        .setParameter("partner_code",handleTdRiskApiDetailRequest.getTongDunReqRiskApiDetailDto().getPartner_code())
        .setParameter("partner_key",handleTdRiskApiDetailRequest.getTongDunReqRiskApiDetailDto().getPartner_key())
        .setParameter("sequence_id",handleTdRiskApiDetailRequest.getTongDunReqRiskApiDetailDto().getSequence_id())
        .setParameter("rule_uuid", handleTdRiskApiDetailRequest.getTongDunReqRiskApiDetailDto().getRule_uuid())
        .build();
		HttpGet httpGet = new HttpGet(uri);  
		httpGet.setConfig(builder.build());
		httpGet.addHeader("Content-Type", "text/html;charset=UTF-8");  
		//发送请求并返回response
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try{
			HttpEntity httpEntity=response.getEntity();
			String reString=EntityUtils.toString(httpEntity);
			logger.info("Reponse Json Data: "+reString);
			tongDunDetailResponseDto.setResinfo(reString.replaceAll(" ", ""));
		}finally{
			response.close();
		}
		}catch(ConnectTimeoutException connectTimeoutException){
			logger.error("--------------------Http连接请求超时", connectTimeoutException);
		}catch(SocketTimeoutException socketTimeoutException){
			logger.error("--------------------Http连接响应超时", socketTimeoutException);
		}finally{
			httpclient.close();
		}
		logger.info("------------------TongDun RemoteDetail Service Time:"+(System.currentTimeMillis()-start));
		logger.info("------------------TongDun RemoteDetail Request End------------------------");
		return tongDunDetailResponseDto;
	}
	
	
	public SSLConnectionSocketFactory getSsl(SSLConnectionSocketFactory ssl){
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				// 信任所有
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
				//解析和管理证书，证书撤销列表（CRL）和证书路径的类和接口
				@Override
				public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType)
						throws java.security.cert.CertificateException {
					return true;
				}
			}).build();
			ssl = new SSLConnectionSocketFactory(sslContext);
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return ssl;
	}


	
}
