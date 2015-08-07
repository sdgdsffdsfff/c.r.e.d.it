package qianhaicredit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.qianhai.service.QianHaiConsumerService;
import common.mutitest.MutiTestRunnerUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext-*.xml" })
@Transactional
public class QianhaiCreditTest {

	@Autowired
	QianHaiConsumerService qianHaiConsumerService;

	@Test
	@Transactional
	@Rollback(false)
	/**
	 * [testMutiThreadWithSingleQHBlklist description]
	 * @throws Exception [description]
	 */
	public void testMutiThreadWithSingleQHBlklist() throws Exception {
		//构造参数
		List<Object> handleRequests = new ArrayList<>();
		HandleRequest handleRequest = new HandleRequest();
		handleRequest.setCustomerName("褚宝刚");
		handleRequest.setCardNo("210202195901160032");
		handleRequests.add(handleRequest);
		
		HandleRequest handleRequest1 = new HandleRequest();
		handleRequest1.setCustomerName("丛爱民");
		handleRequest1.setCardNo("210202195903245427");
		handleRequests.add(handleRequest1);
		
		HandleRequest handleRequest2 = new HandleRequest();
		handleRequest2.setCustomerName("孙德成");
		handleRequest2.setCardNo("210202195903181718");
		handleRequests.add(handleRequest2);
		
		MutiTestRunnerUtil.init(QianHaiConsumerService.class,
				qianHaiConsumerService, "doExecuteSingleRemoteService",
				HandleRequest.class,"applyCode");
		MutiTestRunnerUtil.runTestCase(1,handleRequests);
	}

	/**
	 * 测试前海黑名单 单条请求（默认）
	 */
	@Test
//	@Ignore
	@Transactional
	@Rollback(false)
	public void testSingleQianhaiBlklist() {
		HandleRequest handleRequest = new HandleRequest();
		handleRequest.setApplyCode("Test0007");
		// //1
		handleRequest.setCustomerName("褚宝刚");
		handleRequest.setCardNo("210202195901160032");

		// //2
		// handleRequest.setCustomerName("丛爱民");
		// handleRequest.setCardNo("210202195903245427");

		// //3
		// handleRequest.setCustomerName("孙德成");
		// handleRequest.setCardNo("210202195903181718");

		// 4
		// handleRequest.setCardNo("210202195901160032");
		// handleRequest.setCustomerName("刘慧娟");
		Boolean valEntity = qianHaiConsumerService
				.doExecuteSingleRemoteService(handleRequest);
		System.out.println("姓名：" + handleRequest.getCustomerName()
				+ (true == valEntity ? "命中黑名单" : "未命中黑名单"));
	}

	/**
	 * 测试前海黑名单 多条请求（尚未使用）
	 */
	@Test
	@Ignore
	@Transactional
	@Rollback(false)
	public void testMutiQianhaiBlkListInterface() {
		List<HandleRequest> handleRequests = new ArrayList<>();
		HandleRequest handleRequest = new HandleRequest();
		// 1
		// handleRequest.setCustomerName("褚宝刚");
		// handleRequest.setCardNo("210202195901160032");
		// //2
		// handleRequest.setCustomerName("丛爱民");
		// handleRequest.setCardNo("210202195903245427");
		// 3
		handleRequest.setCustomerName("孙德成");
		handleRequest.setCardNo("210202195903181718");
		handleRequests.add(handleRequest);
		Map<HandleRequest, Boolean> reMap = qianHaiConsumerService
				.doExecuteRemoteService(handleRequests);
		for (Entry<HandleRequest, Boolean> entry : reMap.entrySet()) {
			Boolean valEntity = entry.getValue();
			HandleRequest handleRequest2 = entry.getKey();
			System.out.println("姓名：" + handleRequest2.getCustomerName()
					+ (true == valEntity ? "命中黑名单" : "未命中黑名单"));
		}
	}

}
