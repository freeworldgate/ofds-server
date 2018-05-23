package com.ofds.server.ofdsserver.exception;

import java.io.Serializable;

public enum ErrorCode{

    ENTITY_ERROR(0x03001000,"Entity定义异常"),

    ENTITY_STYLE_ERROR(0x03001001,"Entity定义异常,需要定义Table,Entity,OfdsObjectType注解"),


    ENTITY_NO_OBJECTID_ERROR(0x03001002,"Entity定义异常,必须定义主键objectId" );

    private int error;

    private String msg;

    ErrorCode(int error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
