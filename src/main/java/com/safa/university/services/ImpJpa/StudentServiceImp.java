package com.safa.university.services.ImpJpa;

import com.safa.university.entites.Student;
import com.safa.university.repositories.StudentRepository;
import com.safa.university.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class StudentServiceImp implements StudentService {
    private final  StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student); //save = ajouter + traja3li student
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
         return students;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("No Student With ID: "+id) );
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        if (!studentRepository.existsById(student.getId())){
            throw new NoSuchElementException("No Student With ID: "+student.getId());
          }
        return studentRepository.save(student);
    }

    @Override
    public Student deleteStudent(Long id)
    {
        Student student = studentRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("No Student With ID: "+id) );
         studentRepository.delete(student);
         return student ;
    }

    @Override
    public List<Student>  getStudentByDob(LocalDate dob) {
     List<Student> students = new ArrayList<>();
     studentRepository.findAllByDob(dob).orElse(students).forEach(students::add);
     return students;

    }
}
