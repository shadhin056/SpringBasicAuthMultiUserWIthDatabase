package com.helloworld.helloworld.controller;

import com.helloworld.helloworld.model.StudentModel;
import com.helloworld.helloworld.service.StudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PostMapping("/admin/{id}/admin11")
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


    @PostMapping("/admin/{id}/admin")
    public  @ResponseBody List<StudentModel> dorepsonlist(@PathVariable("id") String id) {
        System.out.println("ID**********=="+id);

        List<StudentModel>  list = new ArrayList<>();
        StudentModel studentModel = new StudentModel();
        if ("1111".equals(id)) {
            studentModel.setOutcode("1111");
            studentModel.setOutMessage("User Is 1111");
           list.add(studentModel);
        } else if ("2222".equals(id)) {

            studentModel.setOutcode("2222");
            studentModel.setOutMessage("User Is 2222");
            list.add(studentModel);
        } else if ("3333".equals(id)) {
            studentModel.setOutcode("3333");
            studentModel.setOutMessage("User Is 3333");
            list.add(studentModel);
        } else if ("4444".equals(id)) {
            studentModel.setOutcode("4444");
            studentModel.setOutMessage("User Is 4444");
            list.add(studentModel);
        } else if ("5555".equals(id)) {
            studentModel.setOutcode("5555");
            studentModel.setOutMessage("User Is 5555");
            list.add(studentModel);
        } else {
            studentModel.setOutcode("5161241");
            studentModel.setOutMessage("User Is Invalid");
            list.add(studentModel);
        }

        return list;
    }

    //delete data
    @DeleteMapping("/students/delete/{id}")
    public void deleteStudentById(@PathVariable("id") int id) {
        studentServiceImp.deleteByIdStudent(id);
    }

}
