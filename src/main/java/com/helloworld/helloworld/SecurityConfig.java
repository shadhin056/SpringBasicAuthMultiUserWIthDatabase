package com.helloworld.helloworld;

import com.helloworld.helloworld.model.UserTypeModel;
import com.helloworld.helloworld.service.UserTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Component
@Configuration
@Order(1)
class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserTypeServiceImp userTypeServiceImp;

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println(userTypeServiceImp.getAllUser());
        List<UserTypeModel> list = userTypeServiceImp.getAllUser();
        for (UserTypeModel model : list) {
            http.csrf().disable()
                    .headers().frameOptions().disable().and()
                    .httpBasic()
                    .and()
                    .authorizeRequests().antMatchers("/admin/" + model.getClinet_id() + "/admin").hasRole(model.getUser_type());
        }
              /*  http.httpBasic()
                .and()
                .authorizeRequests().antMatchers("/admin/12345/admin").hasRole("admin")
                .and()
                .authorizeRequests().antMatchers("/admin/54321/admin").hasRole("user")
                ;*/
    }
}