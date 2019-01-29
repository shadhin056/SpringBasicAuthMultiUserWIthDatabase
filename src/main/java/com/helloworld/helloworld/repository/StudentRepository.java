package com.helloworld.helloworld.repository;

import com.helloworld.helloworld.model.StudentModel;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentModel, Long> {
}
