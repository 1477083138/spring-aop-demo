package hliu.demo.repository;

import hliu.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByName(String name);
}
