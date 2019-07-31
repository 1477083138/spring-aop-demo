package hliu.demo.util;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/7/31.
 * 切面获取注解的类
 */
public class AopUtil {

    /**
     *获取目标方法上的注解
     *
     * */
    public static <T extends Annotation> T findMethodAnnotation(Class targetClass, Method method,Class<T> annClass){
        T a = AnnotationUtils.findAnnotation(method,annClass);
        if(a != null){
            return a;
        }else{
            Method m = ClassUtils.getMostSpecificMethod(method,targetClass);
            a = AnnotationUtils.findAnnotation(m,annClass);
            return a;
        }
    }

    public static <T extends Annotation> T findAnnotation(Class targetClass,Class<T> annClass){
        return AnnotationUtils.findAnnotation(targetClass,annClass);
    }

    public static <T extends Annotation> T findAnnotation(Class targetClass,Method method,Class<T> annClass){
        T a = findMethodAnnotation(targetClass,method,annClass);
        return a!=null ? a : findAnnotation(targetClass,annClass);
    }
}
