package com.ctc.credit.tongdun.api.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDto;
import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDto;
import com.ctc.credit.tongdun.api.service.TongDunReqRiskApiService;
import com.ctc.credit.tongdun.constant.TongDunConstant;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiRequest;
@Service
@Transactional
public class TongDunReqRiskApiServiceImpl implements TongDunReqRiskApiService {
	
	private static Logger logger=Logger.getLogger(TongDunReqRiskApiServiceImpl.class);	
	
	public HttpPost postForm(HandleTdRiskApiRequest handleRequest){  
		List<NameValuePair> nvps = new ArrayList <NameValuePair>();
		Map<String,String> map=new HashMap<String,String>();
		TongDunReqRiskApiDto tongDunReqRiskApiDto=handleRequest.getTongDunReqRiskApiDto();
		InputStream input = null;
		Properties prop = new Properties();
		input = ConfigsContant.class.getClassLoader().getResourceAsStream("tongdun.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			logger.equals(e.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				input = null;
				e.printStackTrace();
			}
		}
		map.put("black_box",tongDunReqRiskApiDto.getBlack_box());
        map.put("partner_code",prop.getProperty("partner_code"));
		map.put("secret_key",prop.getProperty("secret_key"));
		map.put("event_id", tongDunReqRiskApiDto.getEvent_id());
		map.put("token_id", tongDunReqRiskApiDto.getToken_id());
		map.put("cookie_id", tongDunReqRiskApiDto.getCookie_id());
		map.put("ip_address", tongDunReqRiskApiDto.getIp_address());
		map.put("id_number", tongDunReqRiskApiDto.getId_number());
		map.put("account_login", tongDunReqRiskApiDto.getAccount_login()); 
		map.put("account_name", tongDunReqRiskApiDto.getAccount_name());
		map.put("account_email", tongDunReqRiskApiDto.getAccount_email());
		map.put("account_phone", tongDunReqRiskApiDto.getAccount_phone());
		map.put("account_mobile", tongDunReqRiskApiDto.getAccount_mobile());
		map.put("account_password",tongDunReqRiskApiDto.getAccount_password());
		map.put("transaction_id", tongDunReqRiskApiDto.getTransaction_id());
		map.put("organization", tongDunReqRiskApiDto.getOrganization());
		map.put("biz_license", tongDunReqRiskApiDto.getBiz_license());
		map.put("org_code", tongDunReqRiskApiDto.getOrg_code());
		map.put("account_address_street", tongDunReqRiskApiDto.getAccount_address_street());
		map.put("account_address_county", tongDunReqRiskApiDto.getAccount_address_county());
		map.put("account_address_city", tongDunReqRiskApiDto.getAccount_address_city());
		map.put("account_address_province", tongDunReqRiskApiDto.getAccount_address_province());
		map.put("account_address_country", tongDunReqRiskApiDto.getAccount_address_country());
		map.put("account_zip_code", tongDunReqRiskApiDto.getAccount_zip_code());
		map.put("payee_userid", tongDunReqRiskApiDto.getPayee_userid());
		map.put("payee_name", tongDunReqRiskApiDto.getPayee_name());
		map.put("payee_email", tongDunReqRiskApiDto.getPayee_email());
		map.put("payee_mobile", tongDunReqRiskApiDto.getPayee_mobile());
		map.put("payee_phone", tongDunReqRiskApiDto.getPayee_phone());
		map.put("payee_id_number", tongDunReqRiskApiDto.getPayee_id_number());
		map.put("payee_card_number", tongDunReqRiskApiDto.getPayee_card_number());
		map.put("deliver_name", tongDunReqRiskApiDto.getDeliver_name());
		map.put("deliver_mobile", tongDunReqRiskApiDto.getDeliver_mobile());
		map.put("deliver_phone", tongDunReqRiskApiDto.getDeliver_phone());
		map.put("deliver_address_street", tongDunReqRiskApiDto.getDeliver_address_street());
		map.put("deliver_address_county", tongDunReqRiskApiDto.getDeliver_address_county());
		map.put("deliver_address_city", tongDunReqRiskApiDto.getDeliver_address_city());
		map.put("deliver_address_province", tongDunReqRiskApiDto.getDeliver_address_province());
		map.put("deliver_address_country", tongDunReqRiskApiDto.getDeliver_address_country());
		map.put("deliver_zip_code", tongDunReqRiskApiDto.getDeliver_zip_code());
		map.put("pay_id", tongDunReqRiskApiDto.getPay_id());
		map.put("pay_method", tongDunReqRiskApiDto.getPay_method());
		map.put("pay_amount", tongDunReqRiskApiDto.getPay_amount());
		map.put("pay_currency", tongDunReqRiskApiDto.getPay_currency());
		map.put("card_number", tongDunReqRiskApiDto.getCard_number());
		map.put("card_type", tongDunReqRiskApiDto.getCard_type());
		map.put("cc_bin", tongDunReqRiskApiDto.getCc_bin());
		map.put("cc_phone", tongDunReqRiskApiDto.getCc_phone());
		map.put("cc_expiration_year", tongDunReqRiskApiDto.getCc_expiration_year());
		map.put("cc_expiration_month", tongDunReqRiskApiDto.getCc_expiration_month());
		map.put("event_occur_time", tongDunReqRiskApiDto.getEvent_occur_time());
		map.put("user_agent_cust", tongDunReqRiskApiDto.getUser_agent_cust());
		map.put("refer_cust", tongDunReqRiskApiDto.getRefer_cust());
		map.put("items", tongDunReqRiskApiDto.getItems());
		map.put("items_count", tongDunReqRiskApiDto.getItems_count());
		map.put("resp_detail_type", tongDunReqRiskApiDto.getResp_detail_type());
        HttpPost httpost = new HttpPost(TongDunConstant.URL_T);  
        Set<String> keySet = map.keySet();
        for(String key : keySet) {  
            nvps.add(new BasicNameValuePair(key, map.get(key)));
        }
        try {  
            logger.info("set utf-8 form entity to httppost");  
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return httpost;  
    }  
	
	
	@Override
	public TongDunResRiskApiDto getTongDunRiskData(HandleTdRiskApiRequest handleRequest) throws Exception {
		logger.info("------------------TongDun Remote Request Begin------------------------");
		long start=System.currentTimeMillis();
		SSLConnectionSocketFactory ssl=null;
		//创建httpclient对象
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(getSsl(ssl)).build();
		TongDunResRiskApiDto tongDunResponseDto=new TongDunResRiskApiDto();
		try{
			RequestConfig.Builder builder=RequestConfig.custom();
			builder.setSocketTimeout(10000);//响应超时
			builder.setConnectionRequestTimeout(10000);//连接请求超时
			builder.setConnectTimeout(10000);//连接超时
			HttpPost httpPost=postForm(handleRequest);
			httpPost.setConfig(builder.build());
			
			//发送请求并返回response
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try{
				HttpEntity httpEntity=response.getEntity();
				String reString=EntityUtils.toString(httpEntity);
				JSONObject jsonObject=JSONObject.fromObject(reString);
				if(!"true".equals(jsonObject.getString("success"))){
					String reason_code=jsonObject.getString("reason_code");
					if(reason_code.equals("001")){
						logger.info("请检查partner_code及secret_key是否合法有效");
					}else if(reason_code.equals("101")){
						logger.info("请检查API输入字段中, 是否遗漏必填字段");
					}else if(reason_code.equals("102")){
						logger.info("请检查API输入字段中, 是否存在参数类型不正确的。如数值类型字段, 是否误传入非数值的字符串");
					}else if(reason_code.equals("103")){
						logger.info("请检查API输入字段中, 是否存在某些字段传入的数据长度超出字段长度限制");
					}else if(reason_code.equals("404")){
						logger.info("请检查event_id是否合法有效,并且event_id对应的策略未被禁用");
					}else if(reason_code.equals("405")){
						logger.info("内部策略执行超时");
					}else if(reason_code.equals("500")){
						logger.info("内部接口处理错误");
					}
				}
				logger.info("Reponse Json Data: "+reString);
				tongDunResponseDto.setResinfo(reString.replaceAll(" ", ""));
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
		logger.info("------------------TongDun Remote Service Time:"+(System.currentTimeMillis()-start));
		logger.info("------------------TongDun Remote Request End------------------------");
		return tongDunResponseDto;
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
