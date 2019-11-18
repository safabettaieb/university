package com.safa.university.controllers;

import com.safa.university.entites.Class;
import com.safa.university.services.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/classes")
@AllArgsConstructor
public class ClassCtrl {
    private ClassService  classService;

    @GetMapping({"/",""})
    @ResponseStatus(code = HttpStatus.FOUND)
    public List<Class> getAllClasses()
    {
        return classService.getAllClass();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Class getClassById( @PathVariable long id)
    {
        return classService.getClassById(id);

    }

    @PostMapping("/add")
    @ResponseStatus(code =HttpStatus.CREATED)
    public Class addClass(@Valid @RequestBody Class aClass)
    {
        return classService.addClass(aClass);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public Class updateClass(@RequestBody Class aClass)
    {
        return classService.updateClass(aClass);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Class deleteClass(@PathVariable long id)
    {
       return  classService.deleteClass(id);
    }
}
