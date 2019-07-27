package hliu.demo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Entity
@Table(name = "T_TEACHER")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher extends BaseEntity implements Serializable{

    private String name;

    private Integer age;

    @ManyToMany
    @JoinTable(name = "T_TEACHER_STUDENT")
    @OrderBy("id")
    private List<Student> students;

    @Enumerated
    @Column(nullable = false)
    private TeacherStatus status;
}
