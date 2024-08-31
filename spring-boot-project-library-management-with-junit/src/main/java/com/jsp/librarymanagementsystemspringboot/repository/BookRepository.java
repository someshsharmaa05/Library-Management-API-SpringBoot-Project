package com.jsp.librarymanagementsystemspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jsp.librarymanagementsystemspringboot.dto.Book;

import jakarta.transaction.Transactional;

public interface BookRepository  extends JpaRepository<Book, Integer>{

	
}
