package com.example.student_library_management.DTOs;

public class StudentUpdateMobileRequestDTO {


    private int id;
    private String mobile;

    public StudentUpdateMobileRequestDTO() {
    }

    public StudentUpdateMobileRequestDTO(int id, String mobile) {
        this.id = id;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
