package com.ctc.credit.kernel.orm.entity.hibernate.listener;

import java.util.Date;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.event.spi.MergeEvent;
import org.hibernate.event.spi.MergeEventListener;

import com.ctc.credit.kernel.orm.entity.CreditEntity;

public class CreditPreMergeEventListener implements MergeEventListener {

	private static final long serialVersionUID = 6351371285884494795L;

	@Override
	public void onMerge(MergeEvent event) throws HibernateException {
		Object entity = event.getEntity();
	}

	@Override
	public void onMerge(MergeEvent event, Map copiedAlready)
			throws HibernateException {

	}

}
