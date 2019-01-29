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

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class MultipleEntryPointsSecurityConfig {
    @Autowired
    UserTypeServiceImp userTypeServiceImp;

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

    /*for(UserTypeModel model: list){
        System.out.println("User name: "+model.getUsername());
    }*/
        System.out.println(userTypeServiceImp.getAllUser());
        List<UserTypeModel> list = userTypeServiceImp.getAllUser();
        for (UserTypeModel model : list) {
            manager.createUser(User
                    .withUsername(model.getUsername())
                    .password(encoder().encode(model.getPassword()))
                    .roles(model.getUser_type()).build());
        }
        /*for(int i=0;i<3;i++){
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

        }*/

        return manager;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}