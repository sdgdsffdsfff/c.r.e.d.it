package com.ctc.credit.blackgreylist.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.blackgreylist.dao.CreditBlkgraylistDetailEntityDao;
import com.ctc.credit.blackgreylist.dao.IAccountInternalDataDao;
import com.ctc.credit.blackgreylist.dao.IApproveInternalDataDao;
import com.ctc.credit.blackgreylist.factory.BlackNameListBuilder;
import com.ctc.credit.blackgreylist.factory.DangerListDirector;
import com.ctc.credit.blackgreylist.factory.GrayNameListBuilder;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.blackgreylist.service.IInternalData;
import com.ctc.credit.kernel.util.DateUtil;

@Service
@Transactional
public class InternalData implements IInternalData {

	@Autowired
	CreditBlkgraylistDetailEntityDao blkgrayListDetailDao;

	@Autowired
	IAccountInternalDataDao accountInternalDataHibernate;

	@Autowired
	IApproveInternalDataDao approveInternalDataHibernate;

	@Autowired
	private BlackNameListBuilder blackDnlb;

	@Autowired
	private GrayNameListBuilder grayDnlb;

	@Autowired
	private CreditBlkgraylistDetailEntityDao creditBlkgraylistDetailEntityDao;

	public static Map<String,String> levelMap;
	
	private final String GRAY_LIST_A = "疑似欺诈客户灰名单A";
	private final String GRAY_LIST_B = "疑似欺诈客户灰名单B";
	private final String GRAY_LIST_C = "疑似欺诈客户灰名单C";
	private final String GRAY_LIST_D = "疑似欺诈客户灰名单D";
	
	static{
		levelMap = new HashMap<String,String>();
		levelMap.put("02DF", "疑似欺诈客户灰名单C");
		levelMap.put("02JY", "疑似欺诈客户灰名单C");
		levelMap.put("02LD", "疑似欺诈客户灰名单C");
		levelMap.put("02DB", "疑似欺诈客户灰名单C");
		levelMap.put("02SB", "疑似欺诈客户灰名单B");
		levelMap.put("02YT", "疑似欺诈客户灰名单B");
		levelMap.put("02LS", "疑似欺诈客户灰名单B");
		levelMap.put("02ZT", "疑似欺诈客户灰名单B");
		levelMap.put("02HL", "疑似欺诈客户灰名单B");
		levelMap.put("02DY", "疑似欺诈客户灰名单B");
		levelMap.put("02LX", "疑似欺诈客户灰名单B");
		levelMap.put("02JL", "疑似欺诈客户灰名单B");
		levelMap.put("02QL", "疑似欺诈客户灰名单B");
		levelMap.put("02SY", "疑似欺诈客户灰名单B");
		levelMap.put("02ZK", "疑似欺诈客户灰名单B");
		levelMap.put("02ZP", "疑似欺诈客户灰名单B");
		levelMap.put("02QK", "疑似欺诈客户灰名单B");
		levelMap.put("02FS", "疑似欺诈客户灰名单B");
		levelMap.put("02FJ", "疑似欺诈客户灰名单B");
		levelMap.put("02FK", "疑似欺诈客户灰名单B");
		levelMap.put("03XH", "疑似欺诈客户灰名单B");
		levelMap.put("02RF", "疑似欺诈客户灰名单B");
		levelMap.put("02QZ", "疑似欺诈客户灰名单B");
		levelMap.put("02NB", "疑似欺诈客户灰名单B");
		levelMap.put("02NY", "疑似欺诈客户灰名单B");
		levelMap.put("02EY", "疑似欺诈客户灰名单B");
		levelMap.put("02YY", "疑似欺诈客户灰名单B");
		levelMap.put("02WL", "疑似欺诈客户灰名单B");
		levelMap.put("02BL", "疑似欺诈客户灰名单B");
		levelMap.put("02JR", "疑似欺诈客户灰名单B");
		levelMap.put("02YG", "疑似欺诈客户灰名单B");
		levelMap.put("02ZX", "疑似欺诈客户灰名单B");
		levelMap.put("02HZ", "疑似欺诈客户灰名单A");
		levelMap.put("02WZ", "疑似欺诈客户灰名单A");
		levelMap.put("02GZ", "疑似欺诈客户灰名单A");
		levelMap.put("02DW", "疑似欺诈客户灰名单A");
		levelMap.put("02FQ", "疑似欺诈客户灰名单A");
		levelMap.put("02ZG", "疑似欺诈客户灰名单A");
		levelMap.put("02DH", "疑似欺诈客户灰名单D");
	}
	
	
	private CreditBlkgraylistDetailEntity customerInfo2BlkgraylistDetail(
			Map<String, Object> param) {
		CreditBlkgraylistDetailEntity cbde = new CreditBlkgraylistDetailEntity();
		cbde.setApplyNo(param.get("CODE") == null ? "" : param.get("CODE").toString());
		cbde.setCustName(param.get("NAME") == null ? "" : param.get("NAME").toString());
		cbde.setCustIdnum(param.get("CARDNO") == null ? "" :  param.get("CARDNO").toString());
		cbde.setCustMobile(param.get("MOBILE") == null ? "" : param.get("MOBILE").toString());
		cbde.setCustHomeProvince(param.get("ADDRESSPROVINCE") == null ? "" : param.get("ADDRESSPROVINCE").toString());
		cbde.setCustHomeCity(param.get("ADDRESSCITY") == null ? "" : param.get("ADDRESSCITY").toString());
		cbde.setCustHomeDistrict(param.get("ADDRESSDISTRICT") == null ? "" : param.get("ADDRESSDISTRICT").toString());
		cbde.setCustHomeAddress(param.get("ADDRESSDETAIL") == null ? "" : param.get("ADDRESSDETAIL").toString());
		cbde.setCustHomePhone(param.get("PHONE") == null ? "" : param.get("PHONE").toString());
		cbde.setCustCorpName(param.get("COMPANYNAME") == null ? "" : param.get("COMPANYNAME").toString());
		cbde.setCustCorpPhone(param.get("COMPANYPHONE") == null ? "" : param.get("COMPANYPHONE").toString());
		cbde.setCustCorpAddress(param.get("COMPANYADDRESSDETAIL") == null ? "" : param.get("COMPANYADDRESSDETAIL").toString());

		cbde.setEnable(new Long(0));
		cbde.setCreateUser("admin");
		cbde.setCreateDate(DateUtil
				.getFormatDateByyyyyMMddHHmmssFile(new Date()));

		return cbde;
	}
	
	
	@Override
	public int createInternalBadCustomers() {
		// TODO Auto-generated method stub
//		List<String> existingApplyNo = blkgrayListDetailDao
//				.getExistingApplyNo();
//		
//		List<String> blackNameList = accountInternalDataHibernate
//				.getAllApplyCode(existingApplyNo);

//		List<Map<String, Object>> customerInfo = approveInternalDataHibernate
//				.getCustomerInfoByApplyCode(blackNameList);
		List<Map<String, Object>> customerInfo = approveInternalDataHibernate.getInterBadCustomer();
		// Builder模式创建 检索对象
		DangerListDirector blackdd = new DangerListDirector(blackDnlb);
		IDangerList blackdlist = blackdd.createDangerList();
		
		
		for (Map<String, Object> result : customerInfo) {
			CreditBlkgraylistDetailEntity cbde = customerInfo2BlkgraylistDetail(result);

			cbde.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
					.get("内部不良客户黑名单"));
			cbde.setCategoryDesc("内部不良客户黑名单");
			cbde.setWarnLevel(0L);
			cbde = creditBlkgraylistDetailEntityDao.save(cbde);
			blackdlist.initDangerList(cbde);
		}
		
		return customerInfo.size();
				
	}

	@Override
	public int createRiskCustomerInfo() {
		// TODO Auto-generated method stub
//		List<String> existingApplyNo = blkgrayListDetailDao
//				.getExistingApplyNo();

		List<Map<String, Object>> grayList = approveInternalDataHibernate
				.getGrayListInfo();

		// Builder模式创建 检索对象
		DangerListDirector blackdd = new DangerListDirector(blackDnlb);
		IDangerList blackdlist = blackdd.createDangerList();

		DangerListDirector graydd = new DangerListDirector(grayDnlb);
		IDangerList graydlist = graydd.createDangerList();

		/**
		 * 存在“02FS：负面信息-不良嗜好”的拒绝原因时，为该笔申请信息添加一条“不良嗜好黑名单”，同时记录业务数据至该条名单中。
		 * 存在“02FJ：负面信息-家人不同意借款”的拒绝原因时，为该笔申请信息添加一条“家人反对贷款客户黑名单” ，同时记录业务数据至该条名单中。
		 */
		for (Map<String, Object> result : grayList) {

			if ("02FS"
					.equals(result.get("REFUSECODE").toString().toUpperCase())
					|| "02FS".equals(result.get("REFUSECODE2").toString()
							.toUpperCase())
					|| "02FS".equals(result.get("REFUSECODE3").toString()
							.toUpperCase())
					|| "02FS".equals(result.get("REFUSECODE4").toString()
							.toUpperCase())) {
				CreditBlkgraylistDetailEntity cbde = customerInfo2BlkgraylistDetail(result);

				cbde.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
						.get("不良嗜好客户黑名单"));
				cbde.setCategoryDesc("不良嗜好客户黑名单");
				cbde.setWarnLevel(0L);
				cbde = creditBlkgraylistDetailEntityDao.save(cbde);
				blackdlist.initDangerList(cbde);

			} else if ("02FJ".equals(result.get("REFUSECODE").toString()
					.toUpperCase())
					|| "02FJ".equals(result.get("REFUSECODE2").toString()
							.toUpperCase())
					|| "02FJ".equals(result.get("REFUSECODE3").toString()
							.toUpperCase())
					|| "02FJ".equals(result.get("REFUSECODE4").toString()
							.toUpperCase())) {
				CreditBlkgraylistDetailEntity cbde = customerInfo2BlkgraylistDetail(result);
				cbde.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
						.get("家人反对贷款客户黑名单"));
				cbde.setCategoryDesc("家人反对贷款客户黑名单");
				cbde.setWarnLevel(0L);
				cbde = creditBlkgraylistDetailEntityDao.save(cbde);
				blackdlist.initDangerList(cbde);
			}

			/**
			 * 除黑名单外，满足以下条件同时灰名单： u
			 * 根据不同拒绝码使用“疑似欺诈客户灰名单A-D”进行区分添加（不同类别在用于校验时的信息项不同）。 02HZ 02WZ 02GZ
			 * 02DW 02FQ 02ZG u 如果一笔申请满足了“疑似欺诈客户灰名单A”，则不再继续检查是否能否检查B、C、D。 u
			 * 如果不满足A类，则同时检查B和C类能否添加并分别为其添加相应的名单。 02SB 02YT 02LS 02ZT 02HL 02DY
			 * 02LX 02JL 02QL 02SY 02ZK 02ZP 02QK 02FS 02FJ 02FK 03XH 02RF 02QZ
			 * 02NB 02NY 02EY 02YY 02WL 02BL 02JR 02YG 02ZX 02DF 02JY 02LD 02DB
			 * u 如果A类、B类、C类皆不满足，再检查是否满足D类并为其添加名单。 02DH
			 */

			if (GRAY_LIST_A.equals(levelMap.get(result.get("REFUSECODE").toString().toUpperCase()))
				||	GRAY_LIST_A.equals(levelMap.get(result.get("REFUSECODE2").toString().toUpperCase()))
				||	GRAY_LIST_A.equals(levelMap.get(result.get("REFUSECODE3").toString().toUpperCase()))
				||	GRAY_LIST_A.equals(levelMap.get(result.get("REFUSECODE4").toString().toUpperCase()))
					) {
				CreditBlkgraylistDetailEntity cbde = customerInfo2BlkgraylistDetail(result);
				cbde.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
						.get(GRAY_LIST_A));
				cbde.setCategoryDesc(GRAY_LIST_A);
				cbde.setWarnLevel(1L);
				cbde = creditBlkgraylistDetailEntityDao.save(cbde);
				graydlist.initDangerList(cbde);
				continue;
			}
			
			boolean isMatchBC = false;
			
			if (GRAY_LIST_B.equals(levelMap.get(result.get("REFUSECODE").toString().toUpperCase()))
					||	GRAY_LIST_B.equals(levelMap.get(result.get("REFUSECODE2").toString().toUpperCase()))
					||	GRAY_LIST_B.equals(levelMap.get(result.get("REFUSECODE3").toString().toUpperCase()))
					||	GRAY_LIST_B.equals(levelMap.get(result.get("REFUSECODE4").toString().toUpperCase()))
						) {
					CreditBlkgraylistDetailEntity cbde = customerInfo2BlkgraylistDetail(result);
					cbde.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
							.get(GRAY_LIST_B));
					cbde.setCategoryDesc(GRAY_LIST_B);
					cbde.setWarnLevel(1L);
					cbde = creditBlkgraylistDetailEntityDao.save(cbde);
					graydlist.initDangerList(cbde);
					isMatchBC = true;
				}
			
			if (GRAY_LIST_C.equals(levelMap.get(result.get("REFUSECODE").toString().toUpperCase()))
					||	GRAY_LIST_C.equals(levelMap.get(result.get("REFUSECODE2").toString().toUpperCase()))
					||	GRAY_LIST_C.equals(levelMap.get(result.get("REFUSECODE3").toString().toUpperCase()))
					||	GRAY_LIST_C.equals(levelMap.get(result.get("REFUSECODE4").toString().toUpperCase()))
						) {
					CreditBlkgraylistDetailEntity cbde = customerInfo2BlkgraylistDetail(result);
					cbde.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
							.get(GRAY_LIST_C));
					cbde.setCategoryDesc(GRAY_LIST_C);
					cbde.setWarnLevel(1L);
					cbde = creditBlkgraylistDetailEntityDao.save(cbde);
					graydlist.initDangerList(cbde);
					isMatchBC = true;
				}
			
			if(!isMatchBC){
				if (GRAY_LIST_D.equals(levelMap.get(result.get("REFUSECODE").toString().toUpperCase()))
						||	GRAY_LIST_D.equals(levelMap.get(result.get("REFUSECODE2").toString().toUpperCase()))
						||	GRAY_LIST_D.equals(levelMap.get(result.get("REFUSECODE3").toString().toUpperCase()))
						||	GRAY_LIST_D.equals(levelMap.get(result.get("REFUSECODE4").toString().toUpperCase()))
							) {
						CreditBlkgraylistDetailEntity cbde = customerInfo2BlkgraylistDetail(result);
						cbde.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
								.get(GRAY_LIST_D));
						cbde.setCategoryDesc(GRAY_LIST_D);
						cbde.setWarnLevel(1L);
						cbde = creditBlkgraylistDetailEntityDao.save(cbde);
						graydlist.initDangerList(cbde);
						isMatchBC = true;
					}
			}
		}
		return grayList.size();
	}
}
