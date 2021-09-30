package com.h2s.security.service;

import com.h2s.security.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> findAll();
    public Optional<Student> findById(Integer id);
}
