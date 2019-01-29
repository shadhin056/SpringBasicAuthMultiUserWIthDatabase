package com.helloworld.helloworld.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "clinet_id")
    private String clinet_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String 	password;
    @Column(name = "bank_name")
    private String 	bank_name;
    @Column(name = "url")
    private String 	url;
    @Column(name = "user_type")
    private String user_type;

    public UserTypeModel() {
    }

    public UserTypeModel(String clinet_id, String username, String password, String bank_name, String url, String user_type) {
        this.clinet_id = clinet_id;
        this.username = username;
        this.password = password;
        this.bank_name = bank_name;
        this.url = url;
        this.user_type = user_type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClinet_id() {
        return clinet_id;
    }

    public void setClinet_id(String clinet_id) {
        this.clinet_id = clinet_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
