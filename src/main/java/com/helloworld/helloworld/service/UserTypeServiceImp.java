package com.helloworld.helloworld.service;

import com.helloworld.helloworld.model.UserTypeModel;
import com.helloworld.helloworld.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserTypeServiceImp implements UserTypeService {
    @Autowired
    UserTypeRepository userTypeRepository;

    @Override
    public void addUser(UserTypeModel userTypeModel) {
        userTypeRepository.save(userTypeModel);
    }

    @Override
    public UserTypeModel getUserById(long id) {
        return userTypeRepository.findById(id).orElse(null);
    }


    @Override
    public List<UserTypeModel> getAllUser() {
        List<UserTypeModel> userTypeList = new ArrayList<>();
        userTypeRepository.findAll().forEach(userTypeList::add);
        return userTypeList;
    }

    @Override
    public void deleteByIdUser(long id) {
        userTypeRepository.deleteById((long) id);
    }

    @Override
    public List<UserTypeModel> getAllUserByRole() {
        return null;
    }
}
