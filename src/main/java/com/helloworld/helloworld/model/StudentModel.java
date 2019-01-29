package com.helloworld.helloworld.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "course")
    private String course;
    @Column(name = "department")
    private String department;

    public StudentModel() {
    }

    public StudentModel(String name, String course, String department) {
        this.name = name;
        this.course = course;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
