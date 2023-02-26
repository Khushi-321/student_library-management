package com.example.student_library_management.Repositories;

import com.example.student_library_management.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByEmail(String email);


    List<Student> findByCountry(String country);

}
