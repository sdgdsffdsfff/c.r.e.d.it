package tongduncredit;

import javax.transaction.Transactional;

import net.sf.json.JSONObject;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDetailDto;
import com.ctc.credit.tongdun.api.service.TongDunDetailByIdService;
import com.ctc.credit.tongdun.controller.TongDunRiskApiDetailController;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailRequest;
import com.ctc.credit.tongdun.service.TongDunReqRiskApiDetailService;
import com.ctc.credit.tongdun.service.TongDunResRiskApiDetailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/applicationContext-*.xml" })
@Transactional
public class Tongdunriskdetailtest {
	
	@Autowired
	TongDunReqRiskApiDetailService tongDunReqRiskDetailService;
	
	@Autowired
	TongDunDetailByIdService tongDunDetailByIdService;
	
	@Autowired
	TongDunResRiskApiDetailService tongDunResRiskApiDetailService;
	@Autowired
	TongDunRiskApiDetailController tongDunRiskApiDetailController;
	
	@org.junit.Test
	@Transactional
	@Rollback(false)
	public void saveTongDunReqDetailInfo()throws Exception{
		HandleTdRiskApiDetailRequest handleTdRiskApiDetailRequest=new HandleTdRiskApiDetailRequest();
		TongDunReqRiskApiDetailDto tongDunReqRiskApiDetailDto=new TongDunReqRiskApiDetailDto();
		tongDunReqRiskApiDetailDto.setPartner_code("chinatopcredit");
		tongDunReqRiskApiDetailDto.setPartner_key("c02d5865416a499dbded79ce0b9d4457");
		tongDunReqRiskApiDetailDto.setSequence_id("1437528638829-61507787");
		tongDunReqRiskApiDetailDto.setRule_uuid("");
		handleTdRiskApiDetailRequest.setOthers_value("");
		handleTdRiskApiDetailRequest.setTongDunReqRiskApiDetailDto(tongDunReqRiskApiDetailDto);
//		tongDunRiskApiDetailController.queryRiskApiInfoDetail(JSONObject.fromObject(handleTdRiskApiDetailRequest).toString());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* public static String md5(String src) {
	      if (StringUtils.isNotBlank(src)) {
	          try {
	                MessageDigest m = MessageDigest.getInstance("MD5");
	                m.reset();
	                m.update(src.getBytes());
	                byte[] digest = m.digest();
	                BigInteger bigInt = new BigInteger(1, digest);
	                String hashtext = bigInt.toString(16);
	                while (hashtext.length() < 32) {
	                    hashtext = "0" + hashtext;
	                }
	                return hashtext;
	            } catch (NoSuchAlgorithmException e) {
	                logger.error(e.getMessage(), e);
	            }
	      }
	        return null;
	    }*/
	
}
