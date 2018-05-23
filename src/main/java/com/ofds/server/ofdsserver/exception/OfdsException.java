package com.ofds.server.ofdsserver.exception;

public class OfdsException extends Exception {

    private int errorCode;

    private String errorMsg;

    public OfdsException(ErrorCode errorCode){
        this.errorCode = errorCode.getError();
        this.errorMsg = errorCode.getMsg();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "OfdsException{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
