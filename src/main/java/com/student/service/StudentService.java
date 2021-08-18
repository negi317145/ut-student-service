package com.student.service;


import com.feign.dto.StudentDTO;

public interface StudentService {

     StudentDTO registerStudent(StudentDTO studentDTO);

     StudentDTO getStudentByUsername(String username);

}
