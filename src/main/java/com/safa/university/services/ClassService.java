package com.safa.university.services;

import com.safa.university.entites.Class;

import java.util.List;


public interface ClassService {
    Class addClass(Class aClass);
    List<Class> getAllClass();
    Class getClassById(Long id);//rechereche
    Class updateClass(Class aClass);
    Class deleteClass(Long id);

}
