package antifraud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.model.FraudQueryCondition;
import com.ctc.credit.antifraud.rule.IFact;
import com.ctc.credit.antifraud.rule.IRuleManager;
import com.ctc.credit.antifraud.rule.IRuleResult;
import com.ctc.credit.antifraud.rule.IRulesFactory;
import com.ctc.credit.antifraud.rule.impl.IRuleManagerImpl;
import com.ctc.credit.antifraud.service.CustomerInfoService;
import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.jms.service.ProducerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext-*.xml" })
@Transactional
public class AntiFraudGiveBackTestCase {
	
	@Resource(name="iRulesFactory")
	private IRulesFactory iRulesFactory;
	
	@Resource
	private CustomerInfoService customerInfoService;
	
	
	public static void main(String[] args) throws Exception {
		 CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
	            HttpPost httpPost = new HttpPost("http://10.2.129.47:8080/consume/fraud");
	            Map<String, String> reMap = new HashMap<String, String>();
	            reMap.put("applyCode", "X1000001");
	            reMap.put("dealStatus", "0000");
	            reMap.put("dealDesc", "棒槌");
	            String postJson = JSONObject.fromObject(reMap)
						.toString();
				System.out.println("Request Json Data: "+postJson);
				StringEntity stringEntity = new StringEntity(postJson,
						ConfigsContant.UTF_8);// 解决中文乱码问题
				stringEntity.setContentEncoding(ConfigsContant.UTF_8);
				stringEntity.setContentType("application/json");
				httpPost.setEntity(stringEntity);
				RequestConfig.Builder builder = RequestConfig.custom();
				builder.setSocketTimeout(150000);//响应超时
				builder.setConnectionRequestTimeout(150000);
				builder.setConnectTimeout(150000);//连接超时
				httpPost.setConfig(builder.build());
				CloseableHttpResponse response = httpclient.execute(httpPost);
				try {
					HttpEntity entity = response.getEntity();
					String reString = EntityUtils.toString(entity,"utf-8");
					System.out.println("Reponse Json Data: "+reString);
				} finally {
					response.close();
				}
	        } catch (IOException e) {
				e.printStackTrace();
			} finally {
	            httpclient.close();
	        }
	    }
	
}