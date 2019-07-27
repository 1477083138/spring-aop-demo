package hliu.demo.aop;

import hliu.demo.model.Log;
import hliu.demo.repository.SystemLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Administrator on 2019/7/26.
 */

@Aspect
@Component
@Slf4j
public class AopLogService {
    @Autowired
    private SystemLogRepository systemLogRepository;

    public static final String DEFAULTUSER = "default";

    @Pointcut("@annotation(hliu.demo.aop.SystemLogger)")
    public void logger(){

    }

    @Before("logger()")
    public void before(JoinPoint joinPoint)throws Exception{
        String user = DEFAULTUSER;
        if(joinPoint.getArgs().length>0){
            user = String.valueOf(joinPoint.getArgs()[0]);
        }
        String desc = "before:"+getMethodDescription(joinPoint);
        systemLogRepository.save(Log.builder().user(user).descp(desc).build());
        log.info("before: {}", Arrays.toString(joinPoint.getArgs()));
        log.info("before2: {}", desc);
    }

    @After("logger()")
    public void after(JoinPoint joinPoint)throws Exception{

    }

    public static String getMethodDescription(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();//获取目标类名
        String methodName = joinPoint.getSignature().getName();//获取目标方法名

        Object[] arguments = joinPoint.getArgs();//获取参数列表

        Class targetClass = Class.forName(targetName);//通过反射获取目标类

        Method [] methods = targetClass.getMethods();//获取反射类的方法们

        String description = "";

        for(Method method : methods){
            if(method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length){
                    description = method.getAnnotation(SystemLogger.class).description();
                    log.info("getMethodDescription:{}",description);
                    break;
                }
            }
        }
        return description;
    }
}
