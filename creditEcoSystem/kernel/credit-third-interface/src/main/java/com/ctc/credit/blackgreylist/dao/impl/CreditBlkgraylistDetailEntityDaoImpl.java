package com.ctc.credit.blackgreylist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ctc.credit.blackgreylist.dao.CreditBlkgraylistDetailEntityDao;
import com.ctc.credit.blackgreylist.model.BlkGrayListQueryPara;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;

@Repository
public class CreditBlkgraylistDetailEntityDaoImpl extends
		DaoHibernate<CreditBlkgraylistDetailEntity, String> implements
		CreditBlkgraylistDetailEntityDao {

	public CreditBlkgraylistDetailEntityDaoImpl() {
		super(CreditBlkgraylistDetailEntity.class);
	}

	@Override
	public List<CreditBlkgraylistDetailEntity> queryCreditBlkgraylistDetailEntities(
			BlkGrayListQueryPara queryPara) {
		List<Criterion> crilsit = getQueryCriterions(queryPara);
		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("createDate"));
		if (queryPara.getRowLimit()>0&&queryPara.getRowStart()>0)
			return this.getAllPage(queryPara.getRowStart()-1, queryPara.getRowLimit(), crilsit,orders);
		return new ArrayList<CreditBlkgraylistDetailEntity>();
	}

	@Override
	public int queryCount(BlkGrayListQueryPara blkGrayListQueryPara) {
		List<Object> queryParas = new ArrayList<Object>();
		String hql = getQueryPara(blkGrayListQueryPara, queryParas);
		return (int) this.count(hql, queryParas.toArray());
	}

	private String getQueryPara(BlkGrayListQueryPara blkGrayListQueryPara,
			List<Object> queryParas) {
		StringBuilder hqlsb = new StringBuilder();
		hqlsb.append("select count(*) from CreditBlkgraylistDetailEntity en where 1=1");
		if (blkGrayListQueryPara.getWarnLevel()!=null) {
			hqlsb.append(" and en.warnLevel=?");
			queryParas.add(blkGrayListQueryPara.getWarnLevel());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCategoryName())) {
			hqlsb.append(" and en.categoryCode=?");
			queryParas.add(blkGrayListQueryPara.getCategoryName());
		}
		if (null!=blkGrayListQueryPara.getStatus()) {
			hqlsb.append(" and en.enable=?");
			queryParas.add(Long.valueOf(blkGrayListQueryPara.getStatus()));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getListId())) {
			hqlsb.append(" and en.id=?");
			queryParas.add(blkGrayListQueryPara.getListId());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCreateDateBegin())) {
			hqlsb.append(" and en.createDate>?");
			queryParas.add(blkGrayListQueryPara.getCreateDateBegin());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCreateDateEnd())) {
			hqlsb.append(" and en.createDate<?");
			queryParas.add(blkGrayListQueryPara.getCreateDateEnd());
		}
		//--------------- new condition add ---------------------
		if (null!=blkGrayListQueryPara.getSourceSys()) {
			Long sourcesys = blkGrayListQueryPara.getSourceSys();
			if (sourcesys==0l) {
				hqlsb.append(" and (en.sourceSys=? or en.sourceSys is null) ");
			}else {
				hqlsb.append(" and en.sourceSys=?");
			}
			queryParas.add(blkGrayListQueryPara.getSourceSys());
		}
		if (null!=blkGrayListQueryPara.getSourceChannel()) {
			Long channel = blkGrayListQueryPara.getSourceChannel();
			if (channel==0l) {
				hqlsb.append(" and (en.channel=? or en.channel is null) ");
			}else {
				hqlsb.append(" and en.channel=?");
			}
			queryParas.add(blkGrayListQueryPara.getSourceChannel());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getName())) {
			hqlsb.append(" and en.custName like '%'||?||'%'");
			queryParas.add(blkGrayListQueryPara.getName());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getIdNum())) {
			hqlsb.append(" and en.custIdnum like '%'||?||'%'");
			queryParas.add(blkGrayListQueryPara.getIdNum());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getMobile())) {
			hqlsb.append(" and en.custMobile like '%'||?||'%'");
			queryParas.add(blkGrayListQueryPara.getMobile());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getHomephone())) {
			hqlsb.append(" and en.custHomePhone like '%'||?||'%'");
			queryParas.add(blkGrayListQueryPara.getHomephone());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCorpName())) {
			hqlsb.append(" and en.custCorpName like '%'||?||'%'");
			queryParas.add(blkGrayListQueryPara.getCorpName());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCorpPhone())) {
			hqlsb.append(" and en.custCorpPhone like '%'||?||'%'");
			queryParas.add(blkGrayListQueryPara.getCorpPhone());
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCorpAddress())) {
			hqlsb.append(" and en.custCorpAddress like '%'||?||'%'");
			queryParas.add(blkGrayListQueryPara.getCorpAddress());
		}
		return hqlsb.toString();
	}
	
	/**
	 * 分页查询 Criterion 组装
	 * 
	 * @param blkGrayListQueryPara
	 * @param queryParas
	 * @return
	 */
	private List<Criterion> getQueryCriterions(BlkGrayListQueryPara blkGrayListQueryPara) {
		List<Criterion> criterions = new ArrayList<>();
		if (null!=blkGrayListQueryPara.getWarnLevel()) {
			criterions.add(Restrictions.eq("warnLevel", blkGrayListQueryPara.getWarnLevel()));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCategoryName())) {
			criterions.add(Restrictions.eq("categoryCode", blkGrayListQueryPara.getCategoryName()));
		}
		if (null!=blkGrayListQueryPara.getStatus()) {
			criterions.add(Restrictions.eqOrIsNull("enable", blkGrayListQueryPara.getStatus()));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getListId())) {
			criterions.add(Restrictions.eq("id", blkGrayListQueryPara.getListId()));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCreateDateBegin())) {
			criterions.add(Restrictions.gt("createDate", blkGrayListQueryPara.getCreateDateBegin()));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCreateDateEnd())) {
			criterions.add(Restrictions.lt("createDate", blkGrayListQueryPara.getCreateDateEnd()));
		}
		
		//--------------- new condition add ---------------------
		if (null!=blkGrayListQueryPara.getSourceSys()) {
			Long sourcesys = blkGrayListQueryPara.getSourceSys();
			if (new Long(0).equals(sourcesys)) {
				criterions.add(Restrictions.or(Restrictions.eq("sourceSys", new Long(0)),Restrictions.isNull("sourceSys")));
			}else {
				criterions.add(Restrictions.eq("sourceSys", blkGrayListQueryPara.getSourceSys()));
			}
		}
		if (null!=blkGrayListQueryPara.getSourceChannel()) {
			Long channel = blkGrayListQueryPara.getSourceChannel();
			if (new Long(0).equals(channel)) {
				criterions.add(Restrictions.or(Restrictions.eq("channel", new Long(0)),Restrictions.isNull("sourceSys")));
			}else {
				criterions.add(Restrictions.eq("channel", blkGrayListQueryPara.getSourceChannel()));
			}
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getName())) {
			criterions.add(Restrictions.like("custName", "%"+blkGrayListQueryPara.getName()+"%"));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getIdNum())) {
			criterions.add(Restrictions.like("custIdnum", "%"+blkGrayListQueryPara.getIdNum()+"%"));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getMobile())) {
			criterions.add(Restrictions.like("custMobile", "%"+blkGrayListQueryPara.getMobile()+"%"));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getHomephone())) {
			criterions.add(Restrictions.like("custHomePhone", "%"+blkGrayListQueryPara.getHomephone()+"%"));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCorpName())) {
			criterions.add(Restrictions.like("custCorpName", "%"+blkGrayListQueryPara.getCorpName()+"%"));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCorpPhone())) {
			criterions.add(Restrictions.like("custCorpPhone", "%"+blkGrayListQueryPara.getCorpPhone()+"%"));
		}
		if (StringUtils.isNotEmpty(blkGrayListQueryPara.getCorpAddress())) {
			criterions.add(Restrictions.like("custCorpAddress", "%"+blkGrayListQueryPara.getCorpAddress()+"%"));
		}
		return criterions;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CreditBlkgraylistDetailEntity queryBlkgrayEntity(String id) {
		String hql = "from CreditBlkgraylistDetailEntity en where en.id=?";
		List<CreditBlkgraylistDetailEntity> list = this.query(hql,new Object[]{id});
		return list.size()>0?list.get(0):null;
	}

	@Override
	public List<String> getExistingApplyNo() {
		// TODO Auto-generated method stub
		String sql = 
			"	SELECT distinct detail.apply_no "+
			"	FROM CREDIT_BLKGRAYLIST_DETAIL detail "+
			"	inner join  CREDIT_BLKGRAYLIST_ROLE rInfo "+
			"	on detail.id = rInfo.tigger_source "+
			"	where rInfo.TIGGER_TYPE = 1 "+
			"	and rInfo.PRIORITY in (1,2,3,4) ";

		return this.querySql(sql);
	}
}