//package blackGrayListTest;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ctc.credit.blackgreylist.service.IInternalData;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath*:/applicationContext-*.xml" })
//@Transactional
//public class BlackGrayTimeJobTestCase extends AbstractJUnit4SpringContextTests{
//
//	@Autowired
//	IInternalData interData;
//	
//	@Test
//	public void testInterData(){
//		interData.createInternalBadCustomers();
//		interData.createRiskCustomerInfo();
//	}
//}
