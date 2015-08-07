package com.ctc.credit.blackgreylist.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.blackgreylist.dao.CreditBlkgraylistDetailEntityDao;
import com.ctc.credit.blackgreylist.factory.BlackNameListBuilder;
import com.ctc.credit.blackgreylist.factory.DangerListDirector;
import com.ctc.credit.blackgreylist.factory.GrayNameListBuilder;
import com.ctc.credit.blackgreylist.model.BlkGrayListQueryPara;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.service.CreditBlkgraylistDetailEntityService;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.kernel.base.GenericServiceImpl;

@Service
@Transactional
public class CreditBlkgraylistDetailEntityServiceImpl extends
		GenericServiceImpl<CreditBlkgraylistDetailEntity, String> implements
		CreditBlkgraylistDetailEntityService {

	private static Logger logger = Logger
			.getLogger(CreditBlkgraylistDetailEntityServiceImpl.class);

	
	public CreditBlkgraylistDetailEntityServiceImpl() {
	}

	@Autowired
	private CreditBlkgraylistDetailEntityDao creditBlkgraylistDetailEntityDao;

	
	@Autowired
	private BlackNameListBuilder blackDnlb;
	
	@Autowired
	private GrayNameListBuilder grayDnlb;
	
	/**
	 * @return the creditBlkgraylistDetailEntityDao
	 */
	public CreditBlkgraylistDetailEntityDao getCreditBlkgraylistDetailEntityDao() {
		return creditBlkgraylistDetailEntityDao;
	}

	/**
	 * @param creditBlkgraylistDetailEntityDao
	 *            the creditBlkgraylistDetailEntityDao to set
	 */
	public void setCreditBlkgraylistDetailEntityDao(
			CreditBlkgraylistDetailEntityDao creditBlkgraylistDetailEntityDao) {
		this.creditBlkgraylistDetailEntityDao = creditBlkgraylistDetailEntityDao;
	}

	@Override
	public void saveAndCreateIndexs(
			List<CreditBlkgraylistDetailEntity> creditBlkgraylistDetailEntities) {
		// Builder模式创建 检索对象
		DangerListDirector blackdd = new DangerListDirector(blackDnlb);
		IDangerList blackdlist = blackdd.createDangerList();
		
		DangerListDirector graydd = new DangerListDirector(grayDnlb);
		IDangerList graydlist = graydd.createDangerList();
		
		int blkcnt=0;
		int graycnt=0;
		if (creditBlkgraylistDetailEntities!=null) {
			for (CreditBlkgraylistDetailEntity creditBlkgraylistDetailEntity : creditBlkgraylistDetailEntities) {
				CreditBlkgraylistDetailEntity tp = this.save(creditBlkgraylistDetailEntity);
				if(creditBlkgraylistDetailEntity.getWarnLevel() == 0l){
					blackdlist.initDangerList(tp);
					blkcnt++;
				}else{
					graydlist.initDangerList(tp);
					graycnt++;
				}
			}
		}
		logger.info("共生成黑名单索引数据: "+blkcnt+"条。");
		logger.info("共生成灰名单索引数据: "+graycnt+"条。");
	}

	@Override
	public List<CreditBlkgraylistDetailEntity> queryCreditBlkgraylistDetailEntities(
			BlkGrayListQueryPara blkGrayListQueryPara) {
		return creditBlkgraylistDetailEntityDao.queryCreditBlkgraylistDetailEntities(blkGrayListQueryPara);
	}

	@Override
	public int queryCount(BlkGrayListQueryPara blkGrayListQueryPara) {
		return creditBlkgraylistDetailEntityDao.queryCount(blkGrayListQueryPara);
	}

	@Override
	public CreditBlkgraylistDetailEntity queryBlkgrayEntity(String id) {
		return creditBlkgraylistDetailEntityDao.queryBlkgrayEntity(id);
	}

}
