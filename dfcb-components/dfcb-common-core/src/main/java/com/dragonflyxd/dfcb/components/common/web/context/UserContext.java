package com.dragonflyxd.dfcb.components.common.web.context;

import lombok.NoArgsConstructor;

/**
 * 用户 - 上下文
 *
 * @author longfei.chen
 * @since 2020.11.12
 **/
@NoArgsConstructor
public class UserContext {
    private static ThreadLocal<UserInfo> CONTEXT = ThreadLocal.withInitial(UserInfo::new);

    /**
     * 是否为游客
     *
     * @return 判断结果
     */
    public static boolean isGuest() {
        return CONTEXT.get().getGuest();
    }

    /**
     * 获取用户ID
     *
     * @return 用户ID
     */
    public static Long getUserId() {
        return CONTEXT.get().getId();
    }

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    public static String getUsername() {
        return CONTEXT.get().getName();
    }

    /**
     * 获取用户昵称
     *
     * @return 用户昵称
     */
    public static String getNickname() {
        return CONTEXT.get().getNickname();
    }

    /**
     * 获取头像地址
     *
     * @return 头像地址
     */
    public static String getAvatar() {
        return CONTEXT.get().getAvatar();
    }

    /**
     * 获取手机号
     *
     * @return 手机号
     */
    public static String getMobile() {
        return CONTEXT.get().getMobile();
    }

    /**
     * 获取邮箱
     *
     * @return 邮箱
     */
    public static String getEmail() {
        return CONTEXT.get().getEmail();
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    public static UserInfo getUserInfo() {
        return CONTEXT.get();
    }

    /**
     * 设置用户信息
     *
     * @param userInfo 用户信息
     */
    public static void setUserInfo(UserInfo userInfo) {
        reset();
        CONTEXT.set(userInfo);
    }

    /**
     * 重置
     */
    public static void reset() {
        CONTEXT.remove();
    }
}