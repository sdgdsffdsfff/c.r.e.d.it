package com.ctc.credit.kernel.orm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public interface CreditEntity extends Serializable{

    void setId(String id);

    String getId();

    void setCreateUser(String username);

    String getCreateUser();

    void setCreateDate(Date time);

    Date getCreateDate();

    void setUpdateUser(String username);

    String getUpdateUser();

    void setUpdateDate(Date time);

    Date getUpdateDate();
    
}
