package com.student.controller;

import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.feign.dto.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }



    @PostMapping("/register-student")
    public StudentDTO registerStudent(@RequestBody StudentDTO studentDTO){

       return studentService.registerStudent(studentDTO);

    }

    @GetMapping("/getAall-students")
    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }

    @GetMapping("/getStudentByUsername/{username}")
    public StudentDTO getStudentByUsername(@PathVariable("username") String username){

        return studentService.getStudentByUsername(username);
    }

}
