package com.webapi.common.exception;

import com.webapi.common.utils.MessageUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootErrorInfo {

    private Integer lineNumber;
    private String className;
    private String methodName;

    @Override
    public String toString() {
        return MessageUtil.getMessage("rootErrorPosition", className,methodName,lineNumber+"");
    }
}
