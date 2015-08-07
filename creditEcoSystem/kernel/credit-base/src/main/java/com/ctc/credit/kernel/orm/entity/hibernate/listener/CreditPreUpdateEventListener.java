package com.ctc.credit.kernel.orm.entity.hibernate.listener;

import java.util.Date;

import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import com.ctc.credit.kernel.orm.entity.CreditEntity;

public class CreditPreUpdateEventListener implements PreUpdateEventListener {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		Object entity = event.getEntity();
		if (entity != null && entity instanceof CreditEntity) {
			String[] propNames = event.getPersister().getPropertyNames();
			CreditEntity creditEntity = (CreditEntity) entity;
			for (int index = 0; index < propNames.length; index++) {
				// 设置更新日期
				if ("updateDate".equals(propNames[index])) {
					creditEntity.setUpdateDate(new Date(System.currentTimeMillis()));
					event.getState()[index] = creditEntity.getUpdateDate();
				}
				// 设置更新者
				if ("updateUser".equals(propNames[index])) {
					String username = "CreditAdmin";
					creditEntity.setUpdateUser(username);
					event.getState()[index] = creditEntity.getUpdateUser();
				}
			}

		}
		return false;
	}

}
