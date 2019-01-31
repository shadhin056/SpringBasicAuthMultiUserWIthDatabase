package com.helloworld.helloworld;

import com.helloworld.helloworld.model.UserTypeModel;
import com.helloworld.helloworld.repository.UserTypeRepository;
import com.helloworld.helloworld.service.StudentServiceImp;
import com.helloworld.helloworld.service.UserTypeServiceImp;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import sun.misc.BASE64Encoder;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//@EnableWebSecurity
public class MultipleEntryPointsSecurityConfig {
    @Autowired
    UserTypeServiceImp userTypeServiceImp;



    /*@Bean
    public UserDetailsService userDetailsService() throws Exception {



        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

    *//*for(UserTypeModel model: list){
        System.out.println("User name: "+model.getUsername());
    }*//*
        String authString= "1111:1111";
        String encod_user_pass = new BASE64Encoder().encode(authString.getBytes());
        String authStringEnc = "Basic " + encod_user_pass;
        System.out.println("authStringEnc = " + authStringEnc);

        String authString1= "2222:2222";
        String encod_user_pass1 = new BASE64Encoder().encode(authString1.getBytes());
        String authStringEnc1 = "Basic " + encod_user_pass1;
        System.out.println("authStringEnc = " + authStringEnc1);

        String authString2= "3333:3333";
        String encod_user_pass2 = new BASE64Encoder().encode(authString2.getBytes());
        String authStringEnc2 = "Basic " + encod_user_pass2;
        System.out.println("authStringEnc = " + authStringEnc2);


        System.out.println(userTypeServiceImp.getAllUser());
        List<UserTypeModel> list = userTypeServiceImp.getAllUser();
        for (UserTypeModel model : list) {
            manager.createUser(User
                    .withUsername(model.getUsername())
                    .password(encoder().encode(model.getPassword()))
                    .roles(model.getUser_type()).build());
        }
        *//*for(int i=0;i<3;i++){
            if(i==0){
                String a="user";
                manager.createUser(User
                        .withUsername(a)
                        .password(encoder().encode(a))
                        .roles(a).build());
            }else if(i==1){
                String a="admin";
                manager.createUser(User
                        .withUsername(a)
                        .password(encoder().encode(a))
                        .roles(a).build());
            }else if(i==2){
                String a="shadhin";
                manager.createUser(User
                        .withUsername(a)
                        .password(encoder().encode(a))
                        .roles(a).build());
            }

        }*//*

        return manager;
    }*/

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}