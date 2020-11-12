package com.dragonflyxd.dfcb.components.context.dto;

import com.dragonflyxd.dfcb.components.context.bean.BaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.sql.Timestamp;

/**
 * DTO - 基类
 *
 * @author longfei.chen
 * @since 2020.10.23
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BaseDTO extends BaseBean {
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 启用标识
     */
    private Integer enableFlag;
    /**
     * 删除标识
     */
    private Integer deleteFlag;
    /**
     * 创建用户ID
     */
    private Long createdAt;
    /**
     * 创建用户名
     */
    private String createdUserName;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp createdTime;
    /**
     * 更新用户ID
     */
    private Long updatedAt;
    /**
     * 更新用户名
     */
    private String updatedUserName;
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Timestamp updatedTime;
}