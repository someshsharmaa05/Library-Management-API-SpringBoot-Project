package com.jsp.librarymanagementsystemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagementsystemspringboot.dao.BookDao;
import com.jsp.librarymanagementsystemspringboot.dto.Book;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class BookService {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	HttpSession httpSession;

	@Autowired
	BookDao bookDao;

	@Autowired
	ResponseStructure<Book> responseStructure;

	/*
	 * Save book methods
	 */
	public ResponseStructure<Book> saveBook(Book book) {

		if (httpSession.getAttribute("librarianEmail") != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Book-Added-Successfully");
			responseStructure.setData(book);
			bookDao.saveBook(book);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMsg("Data-Not-Added");
			responseStructure.setMsg("Please-Login-With-Librarian-Then-Add");
			responseStructure.setData(null);
			return responseStructure;
		}
	}

	/*
	 * getBookById method 
	 */
	public ResponseStructure<Book> getBookById(int bookId) {

		if (httpSession.getAttribute("librarianEmail") != null) {
			
			Book book=bookDao.getBookById(bookId);
			
			if(book!=null) {
				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMsg("Book-is-Present");
				responseStructure.setData(book);
				return responseStructure;
			}else {
				responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
				responseStructure.setMsg("Given-Book-is-not-present");
				responseStructure.setData(book);
				return responseStructure;
			}
			
		} else {
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseStructure.setMsg("Data-Not-Available");
			responseStructure.setMsg("Please-Login-With-Librarian-Then-Add");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	/*
	 * update book to set student inside book
	 */
	public Book updateBookWithStudentId(int studentId,int BookId) {
		return bookDao.updateBookWithStudentId(studentId, BookId);
	}
}
