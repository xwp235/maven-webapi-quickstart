package com.webapi.common.aspect;

import com.webapi.common.utils.LogUtil;

public interface AccessLogService {

    default void save(LogData log) {
        LogUtil.info("{}",log);
    }

}
