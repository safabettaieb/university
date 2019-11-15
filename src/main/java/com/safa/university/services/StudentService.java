package com.safa.university.services;

import com.safa.university.entites.Student;


import java.time.LocalDate;
import java.util.List;


public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Long id);//rechereche
    Student updateStudent(Student student);
    Student deleteStudent(Long id);
    List<Student> getStudentByDob(LocalDate dob);
}
