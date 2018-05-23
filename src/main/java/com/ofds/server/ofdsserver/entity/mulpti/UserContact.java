package com.ofds.server.ofdsserver.entity.mulpti;


import com.ofds.server.ofdsserver.util.OFDSObjectType;


import javax.persistence.*;

@OFDSObjectType("学校信息")
@Entity
@Table(name="T_User_Contact")
public class UserContact {

    @Id
    @Column(name="用户ID")
    private String objectId;

    @Column(name="朋友ID")
    private String uniquedObjectId;

    @Column(name="添加时间")
    private String time;

    @Column(name="是否看对方朋友圈")
    private String privligeSetting1;

    @Column(name="是否让对方看我的朋友圈")
    private String privligeSetting2;

    public UserContact() {
    }

    public UserContact(String objectId, String uniquedObjectId, String time, String privligeSetting1, String privligeSetting2) {
        this.objectId = objectId;
        this.uniquedObjectId = uniquedObjectId;
        this.time = time;
        this.privligeSetting1 = privligeSetting1;
        this.privligeSetting2 = privligeSetting2;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUniquedObjectId() {
        return uniquedObjectId;
    }

    public void setUniquedObjectId(String uniquedObjectId) {
        this.uniquedObjectId = uniquedObjectId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrivligeSetting1() {
        return privligeSetting1;
    }

    public void setPrivligeSetting1(String privligeSetting1) {
        this.privligeSetting1 = privligeSetting1;
    }

    public String getPrivligeSetting2() {
        return privligeSetting2;
    }

    public void setPrivligeSetting2(String privligeSetting2) {
        this.privligeSetting2 = privligeSetting2;
    }
}
