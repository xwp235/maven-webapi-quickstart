package com.webapi.common.exception.enums;

import com.webapi.common.AppConstants;
import com.webapi.common.ErrorConstants;
import com.webapi.common.utils.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BusinessExceptionEnum implements IBusinessException {

    INVALID_REQUEST_PARAMETER(AppConstants.EXCEPTION_TYPE.WARN, ErrorConstants.ERR_10000, MessageUtil.getMessage("invalidRequestParameters")),
    OBJ_SERIALIZE_2_JSON_FAILED(AppConstants.EXCEPTION_TYPE.ERROR, ErrorConstants.ERR_10001,MessageUtil.getMessage("objSerialize2JsonFailed")),
    JSON_DESERIALIZE_2_OBJ_FAILED(AppConstants.EXCEPTION_TYPE.ERROR, ErrorConstants.ERR_10002, MessageUtil.getMessage("jsonDeserialize2objFailed")),
    DEEP_COPY_OBJ_FAILED(AppConstants.EXCEPTION_TYPE.ERROR, ErrorConstants.ERR_10003, MessageUtil.getMessage("deepCopyObjFailed"));

    private final String type;
    private final int code;
    private final String message;

}
