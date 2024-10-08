package com.jsp.librarymanagementsystemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.librarymanagementsystemspringboot.dto.BookIssue;

public interface BookIssueRepository extends JpaRepository<BookIssue, Integer> {

}
