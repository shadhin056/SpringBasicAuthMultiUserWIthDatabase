package com.helloworld.helloworld;

import com.helloworld.helloworld.dao.UserDao;
import com.helloworld.helloworld.model.UserTypeModel;
import com.helloworld.helloworld.service.UserTypeService;
import com.helloworld.helloworld.service.UserTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    public UserDao userDao;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        //User user = userTypeServiceImp.findUserByUser(userName);
        UserTypeModel model = userDao.getUser(userName);
        System.out.println("user name====>"+model.getUsername()+model.getPassword()+password);

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(model.getUser_type())); // description is a string

        return new UsernamePasswordAuthenticationToken(model.getUsername(), password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}