package hliu.demo.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2019/7/26.
 */
@Setter
@Getter
@ToString
public class NewStudentRequest {
    @NotEmpty
    private String name;
    @NotNull
    private Integer age;
}
