package com.webapi.common.exception;

import com.webapi.common.AppConstants;
import com.webapi.common.ErrorConstants;
import com.webapi.common.utils.MessageUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class SystemException extends RuntimeException{

    private String type;
    private int code;

    public SystemException(int code,Throwable e) {
        super(e);
        this.type = AppConstants.EXCEPTION_TYPE.ERROR;
        this.code = code;
    }

    public SystemException(int code, String message) {
        super(message);
        this.type = AppConstants.EXCEPTION_TYPE.ERROR;
        this.code = code;
    }

    public SystemException() {
        super(MessageUtil.getMessage("serverInternalError"));
        this.type = AppConstants.EXCEPTION_TYPE.ERROR;
        this.code = ErrorConstants.ERR_500;
    }

}
