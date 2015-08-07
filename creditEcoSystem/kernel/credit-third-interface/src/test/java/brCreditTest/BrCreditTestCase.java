package brCreditTest;

import java.text.ParseException;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bfd.facade.Apply_source;
import com.bfd.facade.Biz_industry;
import com.bfd.facade.Biz_positon;
import com.bfd.facade.Biz_type;
import com.bfd.facade.Educationallevel;
import com.bfd.facade.House_type;
import com.bfd.facade.Marriage;
import com.ctc.credit.bairong.api.dto.HandleBrRequest;
import com.ctc.credit.bairong.constant.ConfigsContant;
import com.ctc.credit.bairong.service.BaiRongConsumerService;

/**
 * 测试：百融客户端API接口
 * @author danggang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext-*.xml"})
@Transactional
public class BrCreditTestCase extends AbstractJUnit4SpringContextTests{

	HandleBrRequest handleBrRequest = new HandleBrRequest();
	com.ctc.credit.bairong.constant.ConfigsContant configsContant = new com.ctc.credit.bairong.constant.ConfigsContant();
	@Resource
	private BaiRongConsumerService baiRongConsumerService;
	
	@org.junit.Test
	@Transactional
	@Rollback(false)
	public void Test() throws NumberFormatException, ParseException{
		handleBrRequest.setMerchantName(ConfigsContant.NAME);
		handleBrRequest.setMerchantPwd(ConfigsContant.PASSWORD);
		handleBrRequest.setGid("00720070004d008f00000000000003bd53196a1d");
		handleBrRequest.setMail("402182229@qq.com");
		handleBrRequest.setIdCardNo("370102471212003");
		handleBrRequest.setCell("13400002049");
		handleBrRequest.setAppVisitNum(121);
		handleBrRequest.setHomeAddr("北京市石景山区");
		handleBrRequest.setTelBiz("0833-2601698");
		handleBrRequest.setTelHome("0757-81431665");
		handleBrRequest.setHomeAddr("广东省佛山市南海区罗村街道北湖一路4号时代倾城54栋604房");
		handleBrRequest.setBizAddr("广东省佛山市南海区大沥九龙五金不锈钢交易中心A11座101-102号铺");
		handleBrRequest.setPerAddr("");
		handleBrRequest.setApplyAddr("");
		handleBrRequest.setOthAddr("");
		handleBrRequest.setImei("1231241241521541111");
		handleBrRequest.setImsi("1234tysd");
		handleBrRequest.setMobileType("iPhone6");
		handleBrRequest.setSex("男");
		handleBrRequest.setEducationallevel("college_diploma");
		handleBrRequest.setBizPositon("Middle_managers");
		handleBrRequest.setBizType("Government_affiliated_institutions");
		handleBrRequest.setHouseType("With_the_housing_loan");
		handleBrRequest.setApplySource("Counter_application");
		handleBrRequest.setMarriage("Married");
		handleBrRequest.setBizIndustry("Energy_and_communication_service");
		handleBrRequest.setIncome(1111110);
		handleBrRequest.setBizWorkfor("万度科技有限公司");
		handleBrRequest.setPostalcode("100000");
		handleBrRequest.setApplyProduct("信用卡");
		handleBrRequest.setApplyMoney("10000");
		handleBrRequest.setApplyTime("2014年11月3日 16:47:11");
		handleBrRequest.setLoanReason("花钱");
		handleBrRequest.setBankId("6217000010010884107");
		handleBrRequest.setRefundPeriods(12);
		handleBrRequest.setLinkmanCell("13336169272");
		handleBrRequest.setLinkmanName("张三");
		handleBrRequest.setLinkmanRela("配偶");
		handleBrRequest.setAppVisitNum(30);
		handleBrRequest.setEduAttNum(10);
		handleBrRequest.setBankRunningAttNum(98);
		handleBrRequest.setName("李圆梅");
		handleBrRequest.setBankRunningAttNum(12);
		handleBrRequest.setEduAttNum(2);
		handleBrRequest.setLinkmanAddr("北京");
		handleBrRequest.setLinkmanName("李四");
		baiRongConsumerService.queryUserPortrait(handleBrRequest);
	}
	
}

