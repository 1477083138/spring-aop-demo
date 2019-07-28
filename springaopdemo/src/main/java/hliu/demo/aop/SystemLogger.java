package hliu.demo.aop;

import java.lang.annotation.*;

/**
 * @Description Accesslog:
 * @Author LiHaitao
 * @Date 2018/12/21 15:37
 * @UpdateUser
 * @UpdateDescrip
 * @UpdateDate
 * @Version 1.0.0
 **/


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLogger {
    String descrption() default  "";
}
