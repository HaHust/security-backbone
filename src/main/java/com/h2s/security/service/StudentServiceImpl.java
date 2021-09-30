/*
 * @created 28/09/2021 - 5:35 PM
 * @author vanha
 */

package com.h2s.security.service;

import com.h2s.security.entity.Student;
import com.h2s.security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id){
        return studentRepository.findById(id);
    }
}
