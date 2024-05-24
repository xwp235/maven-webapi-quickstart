package com.webapi.common.exception.enums;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{

    private IBusinessException errorInfo;

    public BusinessException(IBusinessException e) {
        super(e.getMessage());
        this.errorInfo = e;
    }

    /**
     * 不写入堆栈信息，简化异常日志，提高性能
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}
