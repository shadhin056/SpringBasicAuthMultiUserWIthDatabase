package com.helloworld.helloworld.controller;

import com.helloworld.helloworld.model.StudentModel;
import com.helloworld.helloworld.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentServiceImp studentServiceImp;

    @GetMapping(value = "/")
    public String Test() {
        return "Hello World";
    }

    //Insert data
    @PostMapping("/student/add")
    public void addStudnet(@RequestBody StudentModel studentModel) {
        studentServiceImp.addStudent(studentModel);
    }

    //Get all student data
    // @GetMapping("/students")
    @GetMapping("/admin/admin")
    public List<StudentModel> getAllStudnet() {
        return studentServiceImp.getAllStudent();
    }

    //Update data
    @PutMapping("/students/update")
    public void userUpdate(@RequestBody StudentModel studentModel) {
        studentServiceImp.updateStudent(studentModel);
    }

    //Get student by id
    @PostMapping("/admin/{id}/admin")
    public String getStudentById(@PathVariable("id") int id) {

        if (id == 1111) {
            return "1111";
        } else if (id == 2222) {
            return "2222";
        } else if (id == 3333) {
            return "3333";
        } else if (id == 4444) {
            return "4444";
        } else if (id == 5555) {
            return "5555";
        } else {
            return "Invalid";
        }
    }

    //delete data
    @DeleteMapping("/students/delete/{id}")
    public void deleteStudentById(@PathVariable("id") int id) {
        studentServiceImp.deleteByIdStudent(id);
    }

}
