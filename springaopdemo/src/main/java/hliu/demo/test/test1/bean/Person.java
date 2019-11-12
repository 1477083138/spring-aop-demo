package hliu.demo.test.test1.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuhao
 * */
@Data
@ToString
public class Person implements Serializable {

    private String id;
    @JSONField(name = "userName")
    private String name;
    private Integer age;
    private String sex;
    private List<String> oldName;
    private LbStatus status;
}
