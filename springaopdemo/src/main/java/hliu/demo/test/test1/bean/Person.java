package hliu.demo.test.test1.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @author liuhao
 * */
@Data
@ToString
public class Person {
    private String id;
    private String name;
    private Integer age;
    private String sex;
}
