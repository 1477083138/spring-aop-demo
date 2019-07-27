package hliu.demo.service;


import hliu.demo.model.Student;
import hliu.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /*添加学生*/
    public Student saveStudent(String name,Integer age){
        Student student = Student.builder().name(name).age(age).build();
        return studentRepository.save(student);
    }

    /*获取所有学生并且按照ID排序*/
    public List<Student> getAllStudent(){
        return studentRepository.findAll(Sort.by("id"));
    }

    /*按照姓名获取学生*/
    public List<Student> getStudentByName(String name){
        return studentRepository.findByName(name);
    }

    /*按照ID查找学生*/
    public Student get(Long id){
        return studentRepository.getOne(id);
    }

}
