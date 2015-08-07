package tongduncredit;

import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDto;
import com.ctc.credit.tongdun.api.service.TongDunReqRiskApiService;
import com.ctc.credit.tongdun.controller.TongDunRiskApiController;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiRequest;
import com.ctc.credit.tongdun.service.TongDunReqRiskApiInfoService;
import com.ctc.credit.tongdun.service.TongDunResRiskApiService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext-*.xml" })
@Transactional
public class Tongdunrisktest {
	@Autowired
	TongDunReqRiskApiService tongDunReqRiskService;
	@Autowired
	TongDunReqRiskApiInfoService tongDunRiskApiInfoService;
	@Autowired
	TongDunResRiskApiService tongDunResRiskApiService;
	@Autowired
	TongDunRiskApiController tongDunRiskApiController;
	
	@org.junit.Test
	@Transactional
	@Rollback(false)
	public void testTongDunRiskInfo()throws Exception{
		HandleTdRiskApiRequest handleTdRiskApiRequest=new HandleTdRiskApiRequest();
		TongDunReqRiskApiDto tongDunReqRiskApiDto=new TongDunReqRiskApiDto();
		tongDunReqRiskApiDto.setPartner_code("chinatopcredit");
		tongDunReqRiskApiDto.setSecret_key("3acc9e2ea9af4f2089c12d800db0dc7f");
		tongDunReqRiskApiDto.setEvent_id("loan");
		tongDunReqRiskApiDto.setToken_id("your_token_id_to_send_to_api");
		tongDunReqRiskApiDto.setIp_address("192.168.6.2");
		tongDunReqRiskApiDto.setAccount_login("zhangsan");
		tongDunReqRiskApiDto.setId_number("370721197609120017");
		tongDunReqRiskApiDto.setAccount_mobile("13431072436");
		handleTdRiskApiRequest.setOthers_value("");
		handleTdRiskApiRequest.setTongDunReqRiskApiDto(tongDunReqRiskApiDto);
		tongDunRiskApiController.queryRiskApiInfo(JSONObject.fromObject(handleTdRiskApiRequest).toString());

}}
