package com.andrew.annotation;

/**
 * Class
 *
 * @author andrew
 * @date 2020/3/11
 */

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface MyLog {

    /**
     * 要执行的操作类型
     * @return
     */
    String operationType() default "";

    /**
     * 要执行的具体操作
     * @return
     */
    String operationName() default "";

}
