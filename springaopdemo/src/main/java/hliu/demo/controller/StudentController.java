package hliu.demo.controller;

import hliu.demo.controller.request.NewStudentRequest;
import hliu.demo.model.Student;
import hliu.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /*使用consumes限定请求格式为表单格式*/
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED )
    public Student addStudentWithoutBindResult(@Valid NewStudentRequest newStudent){
        return studentService.saveStudent(newStudent.getName(),newStudent.getAge());
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus
    public Student addJsonStudentWithoutBindResult(@Valid @RequestBody NewStudentRequest newStudent){
        return studentService.saveStudent(newStudent.getName(),newStudent.getAge());
    }

    @GetMapping(path = "/" , params = "!name")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }
}
