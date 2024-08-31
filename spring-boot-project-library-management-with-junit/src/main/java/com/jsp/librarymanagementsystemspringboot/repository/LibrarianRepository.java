package com.jsp.librarymanagementsystemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagementsystemspringboot.dto.Librarian;

public interface LibrarianRepository extends JpaRepository<Librarian, Integer> {

}
