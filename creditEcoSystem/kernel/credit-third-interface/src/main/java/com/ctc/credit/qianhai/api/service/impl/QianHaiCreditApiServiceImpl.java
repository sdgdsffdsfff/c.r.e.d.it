package com.ctc.credit.qianhai.api.service.impl;

import java.io.IOException;
import java.net.SocketTimeoutException;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.kernel.util.HttpClientUtil;
import com.ctc.credit.kernel.util.JsonUtil;
import com.ctc.credit.qianhai.api.dto.BlkListRequestDto;
import com.ctc.credit.qianhai.api.dto.BlkListResponseDto;
import com.ctc.credit.qianhai.api.service.QianHaiCreditApiService;
import com.ctc.credit.qianhai.constant.QianHaiEnum;

@Service
public class QianHaiCreditApiServiceImpl implements QianHaiCreditApiService {

	private static Logger logger = Logger
			.getLogger(QianHaiCreditApiServiceImpl.class);

	
	@Override
	public BlkListResponseDto getQianhaiCreditData(
			BlkListRequestDto blkListRequestDto) throws Exception{
		logger.info("----------------QianHai Remote Request Begin------------------------");
		long start = System.currentTimeMillis();
		CloseableHttpClient httpclient = HttpClientUtil.getHttpClient(
				ConfigsContant.QIANHAI_TRUST_KEYSTORE_PATH,
				ConfigsContant.QIANHAI_TRUST_KEYSTORE_PWD);

		BlkListResponseDto blkListResponseDto = null;
		try {
			HttpPost httpPost = new HttpPost(ConfigsContant.QIANHAI_REQUEST_URL);
			String postJson = JSONObject.fromObject(blkListRequestDto)
					.toString();
			logger.info("Request Json Data: "+postJson);
			StringEntity stringEntity = new StringEntity(postJson,
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
//				InputStream in = entity.getContent();
//				StringBuilder sb = new StringBuilder();
//				byte[] tempbytes = new byte[1024];
//				int byteread = 0;
//				// 读入多个字节到字节数组中，byteread为一次读入的字节数
//				while ((byteread = in.read(tempbytes)) != -1) {
//					String block = new String(tempbytes);
//					sb.append(block);
//				}
				String reString = EntityUtils.toString(entity,"utf-8");
				logger.info("Reponse Json Data: "+reString);
				blkListResponseDto = (BlkListResponseDto) JsonUtil.getBean(JSONObject.fromObject(reString), BlkListResponseDto.class);
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
		logger.info("QianHai Remote Service Time：" + (System.currentTimeMillis() - start));
		logger.info("----------------Qianhai Remote Request End------------------------");
		return blkListResponseDto;
	}

}
