package com.helloworld.helloworld.service;

import com.helloworld.helloworld.model.StudentModel;
import com.helloworld.helloworld.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(StudentModel studentModel) {
        studentRepository.save(studentModel);
    }

    @Override
    public void updateStudent(StudentModel studentModel) {
        studentRepository.save(studentModel);
    }

    @Override
    public StudentModel getStudentById(long id) {
        /*Optional<StudentModel> getId = studentRepository.findById((long) id);
        return getId;*/
        return studentRepository.findById((long) id).orElse(null);
    }

    @Override
    public List<StudentModel> getAllStudent() {
        List<StudentModel> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    @Override
    public void deleteByIdStudent(long id) {
        studentRepository.deleteById((long) id);
    }

    @Override
    public List<StudentModel> getAllSTudentByRole() {
        return null;
    }
}
