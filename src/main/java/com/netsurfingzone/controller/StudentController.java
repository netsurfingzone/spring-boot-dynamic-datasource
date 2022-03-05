package com.netsurfingzone.controller;

import com.netsurfingzone.entity.Student;
import com.netsurfingzone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        Student createResponse = studentService.save(student);
        return createResponse;
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        Student updateResponse = studentService.update(student);
        return updateResponse;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        Student getReponse = studentService.get(id);
        return getReponse;
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody Student student) {
        studentService.delete(student);
        return "Record deleted succesfully";
    }
}