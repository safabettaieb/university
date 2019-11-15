package com.safa.university.services.ImpJpa;

import com.safa.university.entites.Class;
import com.safa.university.repositories.ClassRepository;
import com.safa.university.services.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class ClassServiceImp implements ClassService {
    private final ClassRepository classRepository;
    @Override
    public Class addClass(Class aClass) {
        return classRepository.save(aClass);
    }

    @Override
    public List<Class> getAllClass() {
        List<Class> classes = new ArrayList<>();
        classRepository.findAll().forEach(classes::add);
        return classes;
    }

    @Override
    public Class getClassById(Long id) {
        Class aClass = classRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("No Class With ID: "+id) );
        return aClass;
    }

    @Override
    public Class updateClass(Class aClass) {
        if(!classRepository.existsById(aClass.getId())){
            throw new NoSuchElementException("No Class With ID: "+aClass.getId());
        }
        return classRepository.save(aClass);
    }

    @Override
    public Class deleteClass(Long id) {
        Class aclass = getClassById(id);
         classRepository.delete(aclass);
         return aclass;
    }
}
