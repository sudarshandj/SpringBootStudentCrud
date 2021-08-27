package com.example.springbootstudentcrud.repository;

import com.example.springbootstudentcrud.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
