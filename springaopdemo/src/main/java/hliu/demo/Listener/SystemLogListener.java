package hliu.demo.Listener;

import hliu.demo.model.Log;
import hliu.demo.repository.SystemLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/7/31.
 * 注解形式的监听 异步监听日志事件
 */
@Component
public class SystemLogListener {

    @Autowired
    private SystemLogRepository systemLogRepository;

    @Async
    @Order
    @EventListener(SystemLogEvent.class)
    public void saveSystemLog(SystemLogEvent event){
        Log log = (Log) event.getSource();
        //保存日志
        systemLogRepository.save(log);

    }
}
