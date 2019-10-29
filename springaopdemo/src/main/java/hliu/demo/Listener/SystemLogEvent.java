package hliu.demo.Listener;

import hliu.demo.model.Log;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Administrator on 2019/7/31.
 * 系统日志事件
 *
 * 继承后必须重载构造函数，构造函数的参数可以任意指定，其中source参数指的是发生事件的对象，
 * 一般我们在发布事件时使用的是this关键字代替本类对象，而sysLog参数是我们自定义的注册用户对象，
 * 该对象可以在监听内被获取。
 */
public class SystemLogEvent extends ApplicationEvent{
    public SystemLogEvent(Log source){
        super(source);
    }
}
