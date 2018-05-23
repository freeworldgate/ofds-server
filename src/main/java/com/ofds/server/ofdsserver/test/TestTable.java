package com.ofds.server.ofdsserver.test;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author root
 */
@Table(name="测试表")
@Entity
public class TestTable implements Serializable {


    @Id
    @Column(name="你妈的")
    private String schoolId;

    @Column(name="卧槽")
    private String schoolName;

    @Column(name="妈逼")
    private String schoolPath;


    public TestTable() {
    }

    public TestTable(String schoolId, String schoolName, String schoolPath) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolPath = schoolPath;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolPath() {
        return schoolPath;
    }

    public void setSchoolPath(String schoolPath) {
        this.schoolPath = schoolPath;
    }





    @Override
    public String toString() {
        return "SchoolCUT{" +
                "schoolId='" + schoolId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", schoolPath='" + schoolPath + '\'' +
                '}';
    }
}
