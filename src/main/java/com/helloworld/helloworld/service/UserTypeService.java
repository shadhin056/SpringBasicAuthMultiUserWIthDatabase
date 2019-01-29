package com.helloworld.helloworld.service;
import com.helloworld.helloworld.model.UserTypeModel;
import java.util.List;

public interface UserTypeService {
    void addUser(UserTypeModel userTypeModel);

    UserTypeModel getUserById(long id);

    List<UserTypeModel> getAllUser();

    void deleteByIdUser(long id);

    List<UserTypeModel> getAllUserByRole();
}
