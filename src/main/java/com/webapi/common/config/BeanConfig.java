package com.webapi.common.config;

import com.webapi.common.aspect.AccessLogService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "accessLogService")
    public AccessLogService accessLogService() {
        return new AccessLogService() {};
    }

}
