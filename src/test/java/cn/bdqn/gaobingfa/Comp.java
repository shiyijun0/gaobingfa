package cn.bdqn.gaobingfa;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Comp {
    String value() default "1";
    String name() default "syj";
}
