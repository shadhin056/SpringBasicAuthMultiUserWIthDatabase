package com.helloworld.helloworld.repository;

import com.helloworld.helloworld.model.UserTypeModel;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository<UserTypeModel, Long> {
}
