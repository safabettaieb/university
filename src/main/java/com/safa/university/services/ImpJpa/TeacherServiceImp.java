package com.safa.university.services.ImpJpa;

import com.safa.university.entites.Teacher;
import com.safa.university.repositories.TeacherRepository;
import com.safa.university.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class TeacherServiceImp implements TeacherService {
    private final TeacherRepository teacherRepository;
    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
     List<Teacher> teachers =new ArrayList<>();
     teacherRepository.findAll().forEach(teachers::add);
     return teachers;
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("No Teacher With ID: "+id) );
        return  teacher;

    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        if(!teacherRepository.existsById(teacher.getId())){
            throw new NoSuchElementException("No Teacher With ID: "+teacher.getId());
        }
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher deleteTeacher(Long id) {
        Teacher teacher = getTeacherById(id);
        teacherRepository.delete(teacher);
        return teacher;

    }
}
