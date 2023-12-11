package com.example.modul2.service;

import com.example.modul2.modul.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    void addBlog(Student student);

    Student findById(int id);
    int findIndexID(int id);
    void delete(int id);

    void update(int id, Student student);
//    List<Student> findByName(String title);
//    List<S> findByContent(String content);
//
 }
