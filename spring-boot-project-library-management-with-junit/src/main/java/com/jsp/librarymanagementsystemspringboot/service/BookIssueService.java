package com.jsp.librarymanagementsystemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagementsystemspringboot.dao.BookIssueDao;
import com.jsp.librarymanagementsystemspringboot.dao.StudentDao;
import com.jsp.librarymanagementsystemspringboot.dto.BookIssue;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;

import jakarta.servlet.http.HttpSession;

@Service
public class BookIssueService {

	@Autowired
	private HttpSession httpSession;

	@Autowired
	private BookIssueDao bookIssueDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private ResponseStructure<BookIssue> responseStructure;

	/*
	 * update book to set student inside book
	 */
	public ResponseStructure<BookIssue> updateBookWithStudentId(int studentId, int BookId) {

		if (httpSession.getAttribute("librarianEmail") != null) {

			BookIssue bookIssue = bookIssueDao.saveBookIssue(studentId, BookId);

			if (bookIssue != null) {

				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMsg("Book....Issued...Successfully....");
				responseStructure.setData(bookIssue);
				return responseStructure;
			} else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMsg("Book..is...not..Issued...Please..Check..it.");
				responseStructure.setData(null);
				return responseStructure;
			}

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please....Loggedin...with...librarian...");
			responseStructure.setData(null);
			return responseStructure;
		}

	}

	/*
	 * submitbook that student has taken before
	 */
	public ResponseStructure<BookIssue> submitIssuedBook(int bookId, int studentId) {

		if (httpSession.getAttribute("librarianEmail") != null) {

			BookIssue bookIssue = bookIssueDao.submitIssuedBook(bookId, studentId);

			if (bookIssue != null) {

				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMsg("Book....BookSubmitted...Successfully....");
				responseStructure.setData(bookIssue);
				return responseStructure;
			} else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMsg("Book..is...not..submitted...Please..Check..it.");
				responseStructure.setData(null);
				return responseStructure;
			}

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please....Loggedin...with...librarian...");
			responseStructure.setData(null);
			return responseStructure;
		}

	}

	/*
	 * check the fine for late submission
	 */
	public ResponseStructure<BookIssue> checkFineForLateSubmission(int bookId, int studentId) {
		
		if (httpSession.getAttribute("librarianEmail") != null) {

			BookIssue bookIssue = bookIssueDao.checkFineForLateSubmission(bookId, studentId);

			if (bookIssue != null) {

				responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
				responseStructure.setMsg("The Fine Details are Below");
				responseStructure.setData(bookIssue);
				return responseStructure;
			} else {
				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMsg("The fine details are not available please check it");
				responseStructure.setData(null);
				return responseStructure;
			}

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please....Loggedin...with...librarian...");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
}
