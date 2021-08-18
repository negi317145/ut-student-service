package com.student.repository;

import com.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository  extends JpaRepository<Student,Integer> {

    @Query("select s from Student s where s.email=:email")
    public Student findStudentByUsername(String email);

}
