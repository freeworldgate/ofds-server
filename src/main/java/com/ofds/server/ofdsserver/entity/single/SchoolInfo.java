/**  
 * Project Name:ofds-data-jpa  
 * File Name:User.java  
 * Package Name:com.ofds.data.application  
 * Date:2018年5月15日下午11:04:18  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.ofds.server.ofdsserver.entity.single;



import com.fasterxml.jackson.databind.ser.Serializers;
import com.ofds.server.ofdsserver.entity.BaseEntity;
import com.ofds.server.ofdsserver.util.OFDSFeatureType;
import com.ofds.server.ofdsserver.util.OFDSObjectType;
import com.ofds.server.ofdsserver.util.Tip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@OFDSObjectType("学校信息")
@Entity(name= "学校表")
public class SchoolInfo extends BaseEntity<SchoolInfo> {

    @Id
    @Column(name="学校ID")
    @Tip("学校ID")
	private String objectId;

    @Column(name="用户名")
    @OFDSFeatureType("用户名")
    private String username;

    @Column(name = "密码")
    @OFDSFeatureType("密码")
    private String userpwd;

    public SchoolInfo() {
        super();
    }

    public SchoolInfo(String objectId, String username, String userpwd) {
		this();
		this.objectId = objectId;
		this.username = username;
		this.userpwd = userpwd;
	}


	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

	@Override
	public String toString() {
		return "SchoolInfo [objectId=" + objectId + ", username=" + username
				+ ", userpwd=" + userpwd + "]";
	}





}
