package com.safa.university.controllers;

import com.safa.university.entites.Student;
import com.safa.university.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentCtrl {
    private final StudentService studentService;

    @GetMapping({"/",""})
    @ResponseStatus(code = HttpStatus.FOUND)
    public List<Student> getAllStudents()
    {
      return studentService.getAllStudent();
    }
    @GetMapping("/dob/{date}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public List<Student> getStudentsByDob(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return studentService.getStudentByDob(date);
    }
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Student getStudentById(@PathVariable long id)
    {
       return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
   public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);

   }
   @DeleteMapping("/{id}")
   @ResponseStatus(code = HttpStatus.OK)
    public Student deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
   }

}
