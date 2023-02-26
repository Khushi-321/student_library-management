package com.example.student_library_management.Repositories;

import com.example.student_library_management.models.Library_card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Library_card,Integer> {
}
