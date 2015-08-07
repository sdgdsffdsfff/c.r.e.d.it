package com.ctc.credit.kernel.orm.entity.hibernate.listener;

import java.util.Date;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

import com.ctc.credit.kernel.orm.entity.CreditEntity;

/**
 * 数据保存前的 监听器，
 * 
 * @author sunny
 *
 */
@Component("creditPreInsertEventListener")
public class CreditPreInsertEventListener implements PreInsertEventListener {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		Object entity = event.getEntity();
        if (entity != null && entity instanceof CreditEntity) {
            String[] propNames = event.getPersister().getPropertyNames();
            CreditEntity creditEntity = (CreditEntity) entity;
            for (int index = 0; index < propNames.length; index++) {
                // 设置创建日期
                if ("createDate".equals(propNames[index])) {
                	creditEntity.setCreateDate(new Date(System.currentTimeMillis()));
                    event.getState()[index] = creditEntity.getCreateDate();
                }
                // 设置创建者
                else if (creditEntity.getCreateUser() == null && "createUser".equals(propNames[index])) {
                    String username = "CreditAdmin";
                    creditEntity.setCreateUser(username);
                    event.getState()[index] = creditEntity.getCreateUser();
                }
                // 设置更新日期
                else if ("updateDate".equals(propNames[index])) {
                	creditEntity.setUpdateDate(new Date(System.currentTimeMillis()));
					event.getState()[index] = creditEntity.getUpdateDate();
				}
            }
        }
        return false;
	}

}
