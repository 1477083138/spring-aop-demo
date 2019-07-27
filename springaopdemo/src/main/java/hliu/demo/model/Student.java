package hliu.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/7/26.
 */
@Entity
@Table(name = "T_STUDENT")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseEntity implements Serializable{

    private String name;

    private Integer age;
}
