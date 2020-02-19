package com.neuedu.test3.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ldamei
 * @date 2020/2/19 23:26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) // 生命周期
public @interface Column {
    String value();
}
