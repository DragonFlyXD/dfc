package com.dragonflyxd.dfcb.components.common.dao.id;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 雪花ID - 生成器
 *
 * @author longfei.chen
 * @since 2020.10.29
 **/
@Slf4j
class SnowflakeIdWorker {
    private final long workerId;
    private final long epoch = 1603938418468L;
    private final long workerIdBits = 10L;
    private final long maxWorkerId = ~(-1L << this.workerIdBits);
    private long sequence = 0L;
    private final long sequenceBits = 12L;
    private final long workerIdShift = this.sequenceBits;
    private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;
    private final long sequenceMask = ~(-1L << this.sequenceBits);
    private long lastTimestamp = -1L;

    private SnowflakeIdWorker(long workerId) {
        if (workerId > this.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
        }

        this.workerId = workerId;
    }

    static SnowflakeIdWorker getFlowIdWorkerInstance() {
        long workId = 1;

        try {
            byte[] bytes = InetAddress.getLocalHost().getAddress();
            workId = bytes[3] & 0xFF;
        } catch (UnknownHostException e) {
            log.error("SnowflakeIdWorker.getFlowIdWorkerInstance err：{}", e.getMessage());
        }

        return new SnowflakeIdWorker(workId);
    }

    synchronized long nextId() throws Exception {
        long timestamp = SnowflakeIdWorker.timeGen();

        if (this.lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1 & this.sequenceMask;
            if (this.sequence == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }

        if (timestamp < this.lastTimestamp) {
            throw new Exception(String.format("clock moved backwards.Refusing to generate id for %d milliseconds", (this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;

        return timestamp - this.epoch << this.timestampLeftShift | this.workerId << this.workerIdShift | this.sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = SnowflakeIdWorker.timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = SnowflakeIdWorker.timeGen();
        }

        return timestamp;
    }

    private static long timeGen() {
        return System.currentTimeMillis();
    }
}
