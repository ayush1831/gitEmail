package com.training.task2.service;

import com.training.task2.model.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);



    Student updateStudent( int id,Student student);
    void deleteStudent(int id);

    Student updateStudentPArtially(int id, Map<String, Object> fields);

    void deletebyNameAndBranch(String name, String branch);
}
