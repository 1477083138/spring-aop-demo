package hliu.demo.aop;

import hliu.demo.Listener.SystemLogEvent;
import hliu.demo.model.Log;
import hliu.demo.util.AopUtil;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/7/30.
 * 使用StaticMethodMatcherPointcutAdvisor应用切面
 * 静态切入点只在代理创建时执行一次，而不是在运行期间每次调用方法时都执行，所以性能比动态切入点要好，是首选的切入点方式
 */
@Aspect
@Component
@Slf4j
public class SystemLoggerPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {

    @Autowired
    private ApplicationContext applicationContext;

    public SystemLoggerPointcutAdvisor(){
        /*this.setAdvice(new AopLoggerInterceptor(){
            @Override
            public Object invoke(MethodInvocation methodInvocation) {
                Log log = createLog(methodInvocation);
                Object proceed = null;
                try {
                    proceed = methodInvocation.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }finally {
                    //发布事件
                    applicationContext.publishEvent(new SystemLogEvent(log));
                }
                return proceed;
            }
        });*/
        //java8内部类实现 写法
        this.setAdvice((MethodInterceptor) (methodInvocation)-> {
            Log log = createLog(methodInvocation);
            Object proceed = null;
            try {
                proceed = methodInvocation.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }finally {
                //发布事件
                applicationContext.publishEvent(new SystemLogEvent(log));
            }
            return proceed;
        });
    }

    /*处理日志*/
    private Log createLog(MethodInvocation methodInvocation){
        Method method = methodInvocation.getMethod();
        Object inThis = methodInvocation.getThis();

        SystemLogger methodAnnotation = AopUtil.findAnnotation(inThis.getClass(),method,SystemLogger.class);
        String description = methodAnnotation.description();
        Log log = Log.builder().descp(description).user("defaultUser").build();
        return log;
    }

    /*切入点方法匹配方式*/
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return AopUtil.findAnnotation(targetClass,method,SystemLogger.class) != null;
    }

}
