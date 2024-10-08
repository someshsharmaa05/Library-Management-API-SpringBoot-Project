package com.jsp.librarymanagementsystemspringboot.dao;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagementsystemspringboot.dto.Book;
import com.jsp.librarymanagementsystemspringboot.dto.BookIssue;
import com.jsp.librarymanagementsystemspringboot.dto.Student;
import com.jsp.librarymanagementsystemspringboot.repository.BookIssueRepository;
import com.jsp.librarymanagementsystemspringboot.repository.BookRepository;

@Repository
public class BookDao {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookIssueRepository bookIssueRepository;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	BookIssue bookIssue;
	
	public void saveBook(Book book) {
		
		bookRepository.save(book);
	}
	
	/*
	 * getBookById method
	 */
	public Book getBookById(int bookId) {
		
		return bookRepository.findById(bookId).get();
		
	}
	
	/*
	 * update book to set student inside book
	 */
	public Book updateBookWithStudentId(int studentId,int BookId) {
		
		Book book=getBookById(BookId);
		
		Student student = studentDao.getStudentById(studentId);
		
		if((student!=null)&&(book!=null)) {
			
			book.setStudent(student);
			
			bookRepository.save(book);
			
			return book;
			
		}else {
			return null;
		}
	}
}
