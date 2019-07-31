package hliu.demo.aop;

import hliu.demo.Listener.SystemLogEvent;
import hliu.demo.model.Log;
import hliu.demo.util.AopUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/7/30.
 * 创建环绕通知，对指定方法进行切面处理
 * 异步对日志进行处理
 */
public class AopLoggerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        return null;
    }
}
