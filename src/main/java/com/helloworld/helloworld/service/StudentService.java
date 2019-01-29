package com.helloworld.helloworld.service;

import com.helloworld.helloworld.model.StudentModel;

import java.util.List;

public interface StudentService {
    void addStudent(StudentModel studentModel);

    void updateStudent(StudentModel studentModel);

    StudentModel getStudentById(long id);

    List<StudentModel> getAllStudent();

    void deleteByIdStudent(long id);

    List<StudentModel> getAllSTudentByRole();

}
