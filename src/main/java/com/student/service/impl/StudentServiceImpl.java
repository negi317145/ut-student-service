package com.student.service.impl;

import com.feign.dto.StudentDTO;
import com.student.mapper.StudentMapper;
import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentMapper studentMapper;

    @Autowired
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO registerStudent(StudentDTO studentDTO) {

        Student student=studentMapper.dtoToEntity(studentDTO);

        student=studentRepository.save(student);

        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPassword(student.getPassword());
        studentDTO.setAge(student.getAge());
        studentDTO.setRole(student.getRole());

        // impl jwt and generate a token then return that to

        return studentDTO;
    }

    @Override
    public StudentDTO getStudentByUsername(String email) {


       Student student=studentRepository.findStudentByUsername(email);
        StudentDTO studentDTO=new StudentDTO();

        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setPassword(student.getPassword());
        studentDTO.setAge(student.getAge());
        studentDTO.setRole(student.getRole());

        return studentDTO;
    }


}
