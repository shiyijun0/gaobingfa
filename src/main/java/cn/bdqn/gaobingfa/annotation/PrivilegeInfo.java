package cn.bdqn.gaobingfa.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface PrivilegeInfo {
    String value() default "必须拦截到";
}
