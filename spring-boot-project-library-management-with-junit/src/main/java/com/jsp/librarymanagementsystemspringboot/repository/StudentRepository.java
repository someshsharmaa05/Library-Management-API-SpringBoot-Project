package com.jsp.librarymanagementsystemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagementsystemspringboot.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
