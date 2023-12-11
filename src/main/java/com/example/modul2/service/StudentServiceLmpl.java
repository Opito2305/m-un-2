package com.example.modul2.service;
import com.example.modul2.modul.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceLmpl implements StudentService{
    List<Student> students;
    public StudentServiceLmpl(){
        students = new ArrayList<>();
        students.add(new Student(1 ,"a",20,"nam","ha noi",8.0));
        students.add(new Student(2 ,"b",20,"nu","da nang",6.0));
        students.add(new Student(3 ,"c",20,"nam","tp HCM",7.0));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void addBlog(Student student) {
        students.add(student);
    }


    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    @Override
    public int findIndexID(int id) {
        int index =-1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId()==id)
                index=i;
        }
        return index;
    }

    @Override
    public void delete(int id) {
        Student blog=findById(id);
        students.remove(blog);
    }

    @Override
    public void update(int id, Student student) {
        int indexOf = findIndexID(id);
        students.set(indexOf,student);
    }

//    @Override
//    public List<Student> findByName(String title) {
//        List<Student> result = new ArrayList<>();
//        for (Student student : students) {
//            if (student.getTitle().contains(title)) {
//                result.add(student);
//            }
//        }
//        return result;
//    }
//
//    @Override
//    public List<Student> findByContent(String content) {
//        List<Student> result = new ArrayList<>();
//        for (Student student : students) {
//            if (student.getTitle().contains(content)) {
//                result.add(student);
//            }
//        }
//        return null;
//    }
}
