package antifraud;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.ctc.credit.antifraud.controller.AntiFraudController;
import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.model.FraudQueryCondition;
import com.ctc.credit.antifraud.model.HistInfo;
import com.ctc.credit.antifraud.model.SimpleFraudQueryCondition;
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
public class AntiFraudTestCase {
	
    @Autowired
    private ProducerService producerService;
    
    @Resource(name="antiFraudQueueDestination")
    private Destination destination;
    
    @Test
    public void testSend() {
        for (int i=0; i<20; i++) {
            producerService.sendMessage(destination, "棒槌 " + (i+1));
        }
    }
	
	@Resource(name="iRulesFactory")
	private IRulesFactory iRulesFactory;
	
	@Resource
	private CustomerInfoService customerInfoService;
	
	@Resource
	AntiFraudController antiFraudController;

	/**
	 * 反欺诈实时接口调用测试用例
	 */
	@Test
//	@Ignore
	@Transactional
	@Rollback(false)
	public void testCase0002(){
		long begin = System.currentTimeMillis();
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setIdcard("2222222222222");
		customerInfo.setApplyDate(new Date());
		List<ContactsInfo> contactsInfos = new ArrayList<ContactsInfo>();
		ContactsInfo workProver = new ContactsInfo();
		workProver.setRelation("9");
		workProver.setName("刘德华");//!=王毅
		workProver.setMobile("13671900000");
		contactsInfos.add(workProver);
		IFact iFact = new IFact(customerInfo, "A00000001", contactsInfos);
		IRuleManager iRuleManager = new IRuleManagerImpl();
		List<IRuleResult> iRuleResults = iRuleManager.executeRules(iFact,iRulesFactory);
		Boolean flg = false;
		for (IRuleResult iRuleResult : iRuleResults) {
			if (iRuleResult.getRuleResult()) {
				flg = true;
				System.out.println("命中的反欺诈规则为："+iRuleResult.getiRuleCategory().getRuleDesc());
			}
		}
		if (!flg) {
			System.out.println("未命中的反欺诈规则");
		}
		System.out.println("共耗时："+(System.currentTimeMillis()-begin));
	}
	
	/**
	 * 反欺诈实时接口调用测试用例
	 */
	@Test
//	@Ignore
	@Transactional
	@Rollback(false)
	public void testSQl(){
		long begin = System.currentTimeMillis();
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setIdcard("2222222222222");
		List<ContactsInfo> contactsInfos = new ArrayList<ContactsInfo>();
		ContactsInfo workProver = new ContactsInfo();
		workProver.setRelation("1");
		workProver.setName("小米");
		workProver.setMobile("123456789");
		contactsInfos.add(workProver);
		IFact iFact = new IFact(customerInfo, "A00000001", contactsInfos);
		List<String> namesList = new ArrayList<String>();
		namesList.add("小米");
		List<String> nos = new ArrayList<String>();
		nos.add("123456789");
//		customerInfoService.checkRule300006("2222222222222", namesList, nos, "A00000001");
		List<HistInfo>  histInfos = customerInfoService.checkRule300001("2222222222", "13671988607", "A000000011");
		for (HistInfo histInfo : histInfos) {
			System.out.println(histInfo.toString());
		}
		System.out.println("共耗时："+(System.currentTimeMillis()-begin));
	}
	
	@Test
//	@Ignore
	@Transactional
	@Rollback(false)
	public void TestAntiFraudController(){
		SimpleFraudQueryCondition simpleFraudQueryCondition = new SimpleFraudQueryCondition();
		simpleFraudQueryCondition.setApplyCode("T5288769036");
		simpleFraudQueryCondition.setSourceSys("01");
		antiFraudController.getFraudHistData(simpleFraudQueryCondition);
	}
	
	@Test
//	@Ignore
	@Transactional
	@Rollback(false)
	public void TestAntiFraudNowRe(){
		SimpleFraudQueryCondition simpleFraudQueryCondition = new SimpleFraudQueryCondition();
		simpleFraudQueryCondition.setApplyCode("A12345");
		simpleFraudQueryCondition.setSourceSys("01");
		antiFraudController.getFraudHistData(simpleFraudQueryCondition);
	}
	
	public static void main(String[] args) throws Exception {
	
		for (int i = 0; i < 1; i++) {
			long start = System.currentTimeMillis();
			runSingle();
			System.out.println("反欺诈接口耗时："+(System.currentTimeMillis()-start));
		}
	}
	
	 public static void runSingle() throws Exception {
		 CloseableHttpClient httpclient = HttpClients.createDefault();
	        try {
//	            HttpPost httpPost = new HttpPost("http://localhost:8091/zx/service/antifraud/queryantifraud.action");
	            HttpPost httpPost = new HttpPost("http://localhost:8080/credit-third-interface/service/antifraud/queryantifraud.action");
//	            HttpPost httpPost = new HttpPost("http://localhost:8091/zx/service/antifraud/queryantifraudasync.action");
//	            HttpPost httpPost = new HttpPost("http://localhost:8080/credit-third-interface/service/getfraudhistdata.action");
//	            HttpPost httpPost = new HttpPost("http://localhost:8091/zx/service/antifraud/queryantifraudasync.action");
	            CustomerInfo customerInfo = new CustomerInfo();
	    		customerInfo.setIdcard("312312");
//	    		customerInfo.setApplyProductCode("0001");
//	    		customerInfo.setApproveIncome(10000);
	    		customerInfo.setName("刘流");
//	    		customerInfo.setApplyDate(new Date());
//	    		customerInfo.setMobile("13448977867");
//	    		customerInfo.setCompanyPhone("021-234567");
//	    		customerInfo.setCompanyAddrCity("上海市");
//	    		customerInfo.setCompanyName("中腾信金融信息有限公司");
//	    		customerInfo.setHomePhone("021-15430678");
//	    		customerInfo.setCompanyAddresss("虹口区武道场");
//	    		customerInfo.setHomeAddresss("四川北路3号");
//	    		customerInfo.setHousingAddresss("顾唐路1号");
//	    		customerInfo.setSpouseIdno("330102198111252712");
//	    		customerInfo.setSpouseIdtype("01");
//	    		customerInfo.setSpouseName("吴华华");
//	    		customerInfo.setSpouseMobile("13442344485");
	    		List<ContactsInfo> contactsInfos = new ArrayList<ContactsInfo>();
//	    		ContactsInfo workProver = new ContactsInfo();
//	    		workProver.setRelation("3");
//	    		workProver.setName("李刚");
//	    		workProver.setMobile("11415645689");
//	    		workProver.setCompanyPhone("021-10430678");
//	    		contactsInfos.add(workProver);
//	    		ContactsInfo parent = new ContactsInfo();
//	    		parent.setRelation("1");
//	    		parent.setName("老子");
//	    		parent.setMobile("11621811112");
//	    		parent.setCompanyPhone("021-50430678");
//	    		contactsInfos.add(parent);
//	    		ContactsInfo child = new ContactsInfo();
//	    		child.setRelation("2");
//	    		child.setName("小明");
//	    		child.setMobile("11621811112");
//	    		child.setCompanyPhone("021-50430678");
//	    		contactsInfos.add(child);
	    		ContactsInfo otherFamily = new ContactsInfo();
	    		otherFamily.setRelation("9");
	    		otherFamily.setName("小明");
	    		otherFamily.setMobile("13621811111");
//	    		otherFamily.setCompanyPhone("");
	    		contactsInfos.add(otherFamily);
	            FraudQueryCondition f = new FraudQueryCondition();
	            f.setApplyCode("T1000000AZC");
	            f.setContactsInfo(contactsInfos);
	            f.setCustomerInfo(customerInfo);
	            f.setSourceSys("03");
	            f.setQueryType("0");//0 实时借口
	            String postJson = JSONObject.fromObject(f)
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