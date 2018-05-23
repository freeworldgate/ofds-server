/**  
 * Project Name:ofds-data-jpa  
 * File Name:User.java  
 * Package Name:com.ofds.data.application  
 * Date:2018年5月15日下午11:04:18  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package com.ofds.server.ofdsserver.entity.single;

import com.ofds.server.ofdsserver.entity.BaseEntity;
import com.ofds.server.ofdsserver.util.OFDSFeatureType;
import com.ofds.server.ofdsserver.util.OFDSObjectType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@OFDSObjectType("用户")
@Table(name = "t_users")
public class User extends BaseEntity<User> implements Serializable {

    public User(){super();}


    public User(String userId, String username, String userpwd) {
        this.userId = userId;
        this.username = username;
        this.userpwd = userpwd;
    }

    @Id
    private String userId;

    @Column(name="username")
    @OFDSFeatureType("用户名")
    private String username;

    @OFDSFeatureType("用户密码")
    @Column(name = "userpwd")
    private String userpwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userpwd='" + userpwd + '\'' +
                '}';
    }
}
