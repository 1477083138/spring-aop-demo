package hliu.demo.service;

import hliu.demo.model.Student;
import hliu.demo.model.Teacher;
import hliu.demo.model.TeacherStatus;
import hliu.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    /*按照ID查询教师*/
    public Teacher getTeacher(Long id){
        return teacherRepository.getOne(id);
    }

    /*添加教师*/
    public Teacher saveTeacher(String name, Integer age, Student...students){
        Teacher teacher = Teacher.builder()
                .name(name)
                .age(age)
                .students(new ArrayList<>(Arrays.asList(students)))
                .status(TeacherStatus.PROCTICE)
                .build();
        return teacherRepository.save(teacher);
    }

    /*按照Id排序并返回所有教师*/
    public List<Teacher> getAll(){
        return teacherRepository.findAll(Sort.by("id"));
    }
}
