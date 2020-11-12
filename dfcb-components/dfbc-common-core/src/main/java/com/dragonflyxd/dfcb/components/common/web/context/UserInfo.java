package com.dragonflyxd.dfcb.components.common.web.context;

import com.dragonflyxd.dfcb.components.context.bean.BaseBean;
import lombok.Data;

/**
 * 用户信息 - bean
 *
 * @author longfei.chen
 * @since 2020.11.12
 **/
@Data
public class UserInfo extends BaseBean {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 是否为游客
     */
    private Boolean guest;
}