package com.safa.university.services;

import com.safa.university.entites.Teacher;


import java.util.List;

public interface TeacherService {
    Teacher addTeacher(Teacher teacher);
    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Long id);
    Teacher updateTeacher(Teacher teacher);
    Teacher deleteTeacher(Long id);
}
