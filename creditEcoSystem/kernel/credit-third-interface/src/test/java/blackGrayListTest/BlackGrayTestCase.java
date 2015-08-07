//package blackGrayListTest;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import net.sf.json.JSONArray;
//
//import org.apache.commons.net.util.Base64;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.ctc.credit.blackgreylist.controller.DangerNameListController;
//import com.ctc.credit.blackgreylist.factory.BlackNameListBuilder;
//import com.ctc.credit.blackgreylist.factory.DangerListDirector;
//import com.ctc.credit.blackgreylist.factory.GrayNameListBuilder;
//import com.ctc.credit.blackgreylist.factory.IDangerNameListBuilder;
//import com.ctc.credit.blackgreylist.pojo.HandleRequest;
//import com.ctc.credit.blackgreylist.service.IDangerList;
//
//import common.mutitest.MutiTestRunnerUtil;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:/applicationContext-*.xml" })
//@Transactional
//public class BlackGrayTestCase extends AbstractJUnit4SpringContextTests {
//
//	@Autowired
//	DangerNameListController dangerNameListController;
//	
//	@Test
//	public void testMutiBlkListController() throws Exception {
//
//		/***
//		 *{"addressCity":"哈尔滨市","addressDetail":"旭升南街绿海华庭19栋1单元701室","addressDistrict":"香坊区","addressProvince":"黑龙江省","applyCode":"A2015060301372","backupMobile":"","cardNo":"230106198209283828","companyAddressCity":"哈尔滨市","companyAddressDetail":"进乡街114号移动客服楼4楼","companyAddressDistrict":"香坊区","companyAddressProvince":"黑龙江省","companyName":"中国移动通信哈尔滨分公司","companyPhone":"0451-00000000","customerName":"沈明艳","deptCity":"哈尔滨市","mobile":"13945102361","phone":"","respSales":"杜安福","riskLevel":""}
//		 */
//		MutiTestRunnerUtil.init(DangerNameListController.class, dangerNameListController, "showBlackList",
//				String.class, "A2015060301372");
//		String string="{\"addressCity\":\"哈尔滨市\",\"addressDetail\":\"旭升南街绿海华庭19栋1单元701室\",\"addressDistrict\":\"香坊区\",\"addressProvince\":\"黑龙江省\",\"applyCode\":\"A2015060301372\",\"backupMobile\":\"\",\"cardNo\":\"230106198209283828\",\"companyAddressCity\":\"哈尔滨市\",\"companyAddressDetail\":\"进乡街114号移动客服楼4楼\",\"companyAddressDistrict\":\"香坊区\",\"companyAddressProvince\":\"黑龙江省\",\"companyName\":\"中国移动通信哈尔滨分公司\",\"companyPhone\":\"0451-00000000\",\"customerName\":\"沈明艳\",\"deptCity\":\"哈尔滨市\",\"mobile\":\"13945102361\",\"phone\":\"\",\"respSales\":\"杜安福\",\"riskLevel\":\"\"}";
//		// 构造参数
//		List<Object> handleRequests = new ArrayList<>();
//		handleRequests.add(new String(Base64.encodeBase64(string.getBytes("UTF-8"))));
//		MutiTestRunnerUtil.runTestCase(5, handleRequests);
//	}
//
//	// 测试欺诈客户黑名单
//	@Test
//	public void testBUG001() {
//
//		/***
//		 * {customerName=葛新蕾, backupMobile=, companyAddressCity=扬州市,
//		 * phone=021-68027553, riskLevel=, addressCity=伊春市,
//		 * companyPhone=0298-87723422, companyAddressProvince=江苏省,
//		 * addressDistrict=乌马河区, companyName=人蛇集团, addressDetail=中信大厦8楼,
//		 * cardNo=140722198001092028, companyAddressDetail=黑帮路101大楼,
//		 * companyAddressDistrict=维扬区, respSales=李玲, deptCity=佛山市,
//		 * applyCode=A2015051200007, addressProvince=黑龙江省, mobile=17809224222}
//		 */
//		HandleRequest hr = new HandleRequest();
//		hr.setMobile("15000022318");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		System.out.println(dlist.matchDangerList(hr));
//	}
//
//	// 测试欺诈客户黑名单
//	@Test
//	public void testMutiBUG001() throws Exception {
//
//		/***
//		 * {customerName=葛新蕾, backupMobile=, companyAddressCity=扬州市,
//		 * phone=021-68027553, riskLevel=, addressCity=伊春市,
//		 * companyPhone=0298-87723422, companyAddressProvince=江苏省,
//		 * addressDistrict=乌马河区, companyName=人蛇集团, addressDetail=中信大厦8楼,
//		 * cardNo=140722198001092028, companyAddressDetail=黑帮路101大楼,
//		 * companyAddressDistrict=维扬区, respSales=李玲, deptCity=佛山市,
//		 * applyCode=A2015051200007, addressProvince=黑龙江省, mobile=17809224222}
//		 */
//		HandleRequest hr = new HandleRequest();
//		hr.setCardNo("2102021959032454272");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		MutiTestRunnerUtil.init(IDangerList.class, dlist, "matchDangerList",
//				HandleRequest.class, "applyCode");
//		// 构造参数
//		List<Object> handleRequests = new ArrayList<>();
//		handleRequests.add(hr);
//		MutiTestRunnerUtil.runTestCase(10, handleRequests);
//	}
//
//	// 测试欺诈客户黑名单
//	@Test
//	public void test02QZ() {
//		HandleRequest hr = new HandleRequest();
//		hr.setCardNo("310110198701093236");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		assertEquals(
//				"[{\"PRIORITY\":1,\"BLKGRAY_ROLE_CODE\":\"02QZ\",\"TIGGER_INFO\":\"310110198701093236\"}]",
//				JSONArray.fromObject(dlist.matchDangerList(hr)).toString());
//	}
//
//	// 测试内部不良黑名单
//	@Test
//	public void test02NB() {
//		HandleRequest hr = new HandleRequest();
//		hr.setCardNo("310110198701093238");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		assertEquals(
//				"[{\"PRIORITY\":2,\"BLKGRAY_ROLE_CODE\":\"02NB\",\"TIGGER_INFO\":\"310110198701093238\"}]",
//				JSONArray.fromObject(dlist.matchDangerList(hr)).toString());
//	}
//
//	// 测试营业部反馈同行黑名单
//	@Test
//	public void test02YYIndex1() {
//		HandleRequest hr = new HandleRequest();
//		hr.setCardNo("310110198701093237");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		assertEquals(
//				"[{\"PRIORITY\":3,\"BLKGRAY_ROLE_CODE\":\"02YY\",\"TIGGER_INFO\":\"310110198701093237\"}]",
//				JSONArray.fromObject(dlist.matchDangerList(hr)).toString());
//	}
//
//	// 测试营业部反馈同行黑名单姓名＋加星身份证号
//	@Test
//	public void test02YYIndex2() {
//		HandleRequest hr = new HandleRequest();
//		hr.setCardNo("3213333123123120");
//		hr.setCustomerName("李四");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		assertEquals(
//				"[{\"TIGGER_SOURCE\":\"0004\",\"PRIORITY\":3,\"BLKGRAY_ROLE_CODE\":\"02YY\",\"TIGGER_INFO\":\"3213333123123120 李四\"}]",
//				JSONArray.fromObject(dlist.matchDangerList(hr)).toString());
//	}
//
//	// 测试营业部反馈同行黑名单姓名＋加星身份证号
//	@Test
//	public void test02YYIndex3False() {
//		HandleRequest hr = new HandleRequest();
//		hr.setMobile("13585954194");
//		hr.setCustomerName("张文珺");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		assertEquals("[null]", JSONArray.fromObject(dlist.matchDangerList(hr))
//				.toString());
//	}
//
//	// 测试营业部反馈同行黑名单姓名＋加星身份证号
//	@Test
//	public void test02YYIndex3True() {
//		HandleRequest hr = new HandleRequest();
//		hr.setMobile("13585954194");
//		hr.setCustomerName("叶敬意");
//		IDangerNameListBuilder dnlb = (BlackNameListBuilder) applicationContext
//				.getBean("blackNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		assertEquals("", JSONArray.fromObject(dlist.matchDangerList(hr))
//				.toString());
//	}
//
//	// 测试欺诈客户灰名单
//	@Test
//	public void testgalyList01() {
//		HandleRequest hr = new HandleRequest();
//		hr.setMobile("13585954194");
//		hr.setCardNo("310191817192321232");
//		hr.setAddressDetail("中信大厦8楼");
//		IDangerNameListBuilder dnlb = (GrayNameListBuilder) applicationContext
//				.getBean("grayNameListBuilder");// SpringContextHelper.getBean("blackNameListBuilder");
//		DangerListDirector dd = new DangerListDirector(dnlb);
//		IDangerList dlist = dd.createDangerList();
//		System.out.println(JSONArray.fromObject(dlist.matchDangerList(hr))
//				.toString());
//	}
//
//}
