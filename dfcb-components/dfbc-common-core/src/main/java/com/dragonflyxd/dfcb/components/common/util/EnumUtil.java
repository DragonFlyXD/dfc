package com.dragonflyxd.dfcb.components.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;

/**
 * 枚举 - 工具
 *
 * @author longfei.chen
 * @since 2020.10.23
 **/
@Slf4j
public class EnumUtil {
    private static final String GET_CODE_METHOD = "getCode";

    /**
     * 根据code获取枚举
     *
     * @param values 枚举集合
     * @param code   编码
     * @return 枚举
     */
    public static <T extends Enum> T getByCode(T[] values, Object code) {
        if (ArrayUtils.isEmpty(values) || null == code) {
            return null;
        }

        for (Enum e : values) {
            if (null == e) {
                continue;
            }

            try {
                Method m = e.getClass().getMethod(GET_CODE_METHOD);

                if (code.equals(m.invoke(e))) {
                    return (T) e;
                }
            } catch (Exception ex) {
                log.error("EnumUtil.getByCode err：{}", ex.getMessage());
            }
        }

        return null;
    }
}