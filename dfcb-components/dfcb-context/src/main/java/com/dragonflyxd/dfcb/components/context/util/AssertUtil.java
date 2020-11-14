package com.dragonflyxd.dfcb.components.context.util;

import com.dragonflyxd.dfcb.components.context.exception.BizException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

/**
 * 断言 - 工具
 *
 * @author longfei.chen
 * @since 2020.10.26
 **/
public class AssertUtil {
    public static void isBlank(String str, String code) {
        if (StringUtils.isNotBlank(str)) {
            error(code);
        }
    }

    public static void isBlank(String str, String code, Object[] args) {
        if (StringUtils.isNotBlank(str)) {
            error(code, args);
        }
    }

    public static void notBlank(String str, String code) {
        if (StringUtils.isBlank(str)) {
            error(code);
        }
    }

    public static void notBlank(String str, String code, Object[] args) {
        if (StringUtils.isBlank(str)) {
            error(code, args);
        }
    }

    public static void isZero(int val, String code) {
        if (0 != val) {
            error(code);
        }
    }

    public static void isZero(int val, String code, Object[] args) {
        if (0 != val) {
            error(code, args);
        }
    }

    public static void notZero(int val, String code) {
        if (0 == val) {
            error(code);
        }
    }

    public static void notZero(int val, String code, Object[] args) {
        if (0 == val) {
            error(code, args);
        }
    }

    public static void isEmpty(Collection<?> collection, String code) {
        if (CollectionUtils.isNotEmpty(collection)) {
            error(code);
        }
    }

    public static void isEmpty(Collection<?> collection, String code, Object[] args) {
        if (CollectionUtils.isNotEmpty(collection)) {
            error(code, args);
        }
    }

    public static void notEmpty(Collection<?> collection, String code) {
        if (CollectionUtils.isEmpty(collection)) {
            error(code);
        }
    }

    public static void notEmpty(Collection<?> collection, String code, Object[] args) {
        if (CollectionUtils.isEmpty(collection)) {
            error(code, args);
        }
    }

    public static void isNull(Object obj, String code) {
        if (null != obj) {
            error(code);
        }
    }

    public static void isNull(Object obj, String code, Object[] args) {
        if (null != obj) {
            error(code, args);
        }
    }

    public static void notNull(Object obj, String code) {
        if (null == obj) {
            error(code);
        }
    }

    public static void notNull(Object obj, String code, Object[] args) {
        if (null == obj) {
            error(code, args);
        }
    }

    public static void isTrue(boolean exp, String code) {
        if (!exp) {
            error(code);
        }
    }

    public static void isTrue(boolean exp, String code, Object[] args) {
        if (!exp) {
            error(code, args);
        }
    }

    public static void notTrue(boolean exp, String code) {
        if (exp) {
            error(code);
        }
    }

    public static void notTrue(boolean exp, String code, Object[] args) {
        if (exp) {
            error(code, args);
        }
    }

    private static void error(String code) {
        throw new BizException(code);
    }

    private static void error(String code, Object[] args) {
        throw new BizException(code, args);
    }
}