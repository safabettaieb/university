package com.safa.university.controllers;

import com.safa.university.entites.Teacher;
import com.safa.university.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
@AllArgsConstructor
public class TeacherCtrl {
    private TeacherService teacherService;

    @GetMapping({"/",""})
    @ResponseStatus(code = HttpStatus.FOUND)
    public List<Teacher> getAllTeacher()
    {

        return teacherService.getAllTeacher();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Teacher getTeacherById(@PathVariable long id)
    {
        return teacherService.getTeacherById(id);

    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher)
    {
        return teacherService.addTeacher(teacher);
    }
    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public Teacher updateTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.updateTeacher(teacher);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Teacher deleteTeacher(@PathVariable long id)
    {
        return teacherService.deleteTeacher(id);
    }
}
