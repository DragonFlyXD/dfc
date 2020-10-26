package com.dragonflyxd.dfcb.components.common.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.dragonflyxd.dfcb.components.common.bean.BaseBean;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 实体 - 基类
 *
 * @author longfei.chen
 * @since 2020.10.23
 **/
@Data
public class BaseEntity extends BaseBean {
    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 启用标识
     */
    private Integer enableFlag;
    /**
     * 删除标识
     */
    @TableLogic
    private Integer deleteFlag;
    /**
     * 创建用户ID
     */
    private Long createdAt;
    /**
     * 创建时间
     */
    private Timestamp createdTime;
    /**
     * 更新用户ID
     */
    private Long updatedAt;
    /**
     * 更新时间
     */
    @Version
    private Timestamp updatedTime;
}