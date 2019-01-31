package com.helloworld.helloworld.dao;

import com.helloworld.helloworld.model.StudentModel;
import com.helloworld.helloworld.model.UserTypeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserTypeModel getUser(String username ) {
        UserTypeModel userTypeModel = new UserTypeModel();
        Connection con = null;
        String sql = "SELECT * FROM `user` Where username = ? ";
        try {
            con = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
             while(rs.next()){

                 userTypeModel.setUsername(rs.getString("username"));
                 userTypeModel.setPassword(rs.getString("password"));
                 userTypeModel.setUser_type(rs.getString("user_type"));

             }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return userTypeModel;
    }

}
