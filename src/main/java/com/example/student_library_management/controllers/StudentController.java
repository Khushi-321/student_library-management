package com.example.student_library_management.controllers;

import com.example.student_library_management.DTOs.StudentUpdateMobileRequestDTO;
import com.example.student_library_management.models.Student;
import com.example.student_library_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;
    private String student;

    @PostMapping("/add")

    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);

    }

    @GetMapping("/get_name")
    public String getNameByEmail(@RequestParam("email") String email){
        return studentService.findNameByEmail(email);

    }

    @PutMapping("/update_mobileNo")
    public  String updateMobNo(@RequestBody StudentUpdateMobileRequestDTO studentRequestDTO){

        return studentService.updateMobNo(studentRequestDTO);
    }

}
// Existing functions without defining them
// Existing function with defining
// New functions which are not inbuilt