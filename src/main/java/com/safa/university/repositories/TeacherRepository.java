package com.safa.university.repositories;

import com.safa.university.entites.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher,Long> {
}
