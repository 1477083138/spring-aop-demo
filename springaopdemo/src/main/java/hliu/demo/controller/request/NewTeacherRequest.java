package hliu.demo.controller.request;

import hliu.demo.model.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */

@Getter
@Setter
@ToString
public class NewTeacherRequest {
    private String name;
    private Integer age;
    private List<Student> students;
}
