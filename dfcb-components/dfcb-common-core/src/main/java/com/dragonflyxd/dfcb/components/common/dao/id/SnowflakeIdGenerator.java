package com.dragonflyxd.dfcb.components.common.dao.id;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 雪花ID - 生成器
 *
 * @author longfei.chen
 * @since 2020.10.29
 **/
@Slf4j
@Component
public class SnowflakeIdGenerator implements IdGenerator<Long> {
    private final static SnowflakeIdWorker SNOWFLAKE_ID_WORKER = SnowflakeIdWorker.getFlowIdWorkerInstance();

    @Override
    public Long generateId() {
        try {
            return SNOWFLAKE_ID_WORKER.nextId();
        } catch (Exception e) {
            log.error("SnowflakeIdGenerator.generateId err：{}", e.getMessage());
        }

        return null;
    }
}
