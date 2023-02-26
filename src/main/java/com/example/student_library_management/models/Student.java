package com.example.student_library_management.models;

import javax.persistence.*;

@Entity
@Table(name="Student_info")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // id will be auto generated
    private int id;

    private String name;
    @Column(unique = true)
    private String email;
    private String mobile;
    private int age;
    private String country;

    //Plain syntax for bidirectional mapping
    // Name of variable of parent entity that you have written in child class foreign key attribute
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Library_card card;

    public Student() {
    }

    public Library_card getCard() {
        return card;
    }

    public void setCard(Library_card card) {
        this.card = card;
    }

    public Student(int id, String name, String email, String mobile, int age, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
