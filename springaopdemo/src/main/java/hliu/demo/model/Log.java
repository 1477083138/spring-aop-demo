package hliu.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/7/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_LOG")
@Builder
public class Log extends BaseEntity implements Serializable{
    private String descp;
    private String user;
}
