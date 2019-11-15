package com.safa.university.repositories;

import com.safa.university.entites.Student;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Long> {
    // 1 student // + students
    Optional<List<Student>> findAllByDob(LocalDate date);
    Optional<Student> findByCin(int cin);
}
