/*
 * @created 28/09/2021 - 5:29 PM
 * @author vanha
 */

package com.h2s.security.controller;

import com.h2s.security.entity.Student;
import com.h2s.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
public class StudentController{

    @Autowired
    private StudentService studentService;

    @GetMapping(path = "")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(path = "{studentId}")
    public Optional<Student> getStudent(@PathVariable("studentId") Integer studentId){
        return studentService.findById(studentId);
    }
}

