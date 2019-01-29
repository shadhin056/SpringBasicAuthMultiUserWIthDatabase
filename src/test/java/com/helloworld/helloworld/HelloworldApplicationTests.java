package com.helloworld.helloworld;

import com.helloworld.helloworld.model.StudentModel;
import com.helloworld.helloworld.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloworldApplicationTests {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateHW() {
        StudentModel studentModel = new StudentModel();
        studentModel.setName("ShadhiN");
        studentModel.setCourse("CSE");
        studentModel.setDepartment("CSE");
        studentRepository.save(studentModel);
    }

}

