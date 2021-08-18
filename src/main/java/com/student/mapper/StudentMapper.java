package com.student.mapper;

import com.feign.dto.StudentDTO;
import com.student.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public Student dtoToEntity(StudentDTO studentDTO) {

        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());

        student.setPassword(studentDTO.getPassword());

        student.setAge(studentDTO.getAge());
        student.setRole(studentDTO.getRole());

        System.out.println("student mapper " + studentDTO.getRole());

        return student;
    }


    public List<Student> dtosToEntities(List<StudentDTO> studentDTO) {
        return studentDTO.stream().map(s -> dtoToEntity(s)).collect(Collectors.toList());
    }


    public StudentDTO entityToDTO(Student student) {

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPassword(student.getPassword());

        studentDTO.setAge(student.getAge());
        studentDTO.setRole(student.getRole());

        return studentDTO;
    }


    public List<StudentDTO> entitiesToDtos(List<Student> student) {

        return student.stream().map(s -> entityToDTO(s)).collect(Collectors.toList());
    }


}
