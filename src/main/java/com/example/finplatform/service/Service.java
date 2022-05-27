package com.example.finplatform.service;

import com.example.finplatform.model.Student;
import com.example.finplatform.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Service {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Transactional
    public void delete(Integer id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
        } else {
            System.out.printf("Student with id = %s is not exist", id);
        }
    }

    public void add(Student student) {
        studentRepository.save(student);
    }
}