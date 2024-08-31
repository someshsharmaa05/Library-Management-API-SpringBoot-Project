package com.jsp.librarymanagementsystemspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagementsystemspringboot.dto.Book;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;

	@PostMapping("/saveBook")
	public ResponseStructure<Book> saveBook(@RequestBody Book book){
		return bookService.saveBook(book);
	}
}
