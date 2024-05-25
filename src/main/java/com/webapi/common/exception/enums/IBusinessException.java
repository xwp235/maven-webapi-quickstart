package com.webapi.common.exception.enums;

public interface IBusinessException {

    int getCode();
    String getType();
    boolean shouldLog();
    String getMessage();

}
