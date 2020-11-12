package com.dragonflyxd.dfcb.components.common.configuration;


import com.dragonflyxd.dfcb.components.common.dao.id.IdGenerator;
import com.dragonflyxd.dfcb.components.common.dao.id.SnowflakeIdGenerator;
import com.dragonflyxd.dfcb.components.common.web.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动 - 配置类
 *
 * @author longfei.chen
 * @since 2020.11.12
 **/
@Configuration
public class AutoConfiguration {
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public IdGenerator<Long> idGenerator() {
        return new SnowflakeIdGenerator();
    }
}
