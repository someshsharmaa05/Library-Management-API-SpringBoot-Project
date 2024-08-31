package com.jsp.librarymanagementsystemspringboot.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagementsystemspringboot.dto.Book;
import com.jsp.librarymanagementsystemspringboot.dto.BookIssue;
import com.jsp.librarymanagementsystemspringboot.dto.Student;
import com.jsp.librarymanagementsystemspringboot.repository.BookIssueRepository;
import com.jsp.librarymanagementsystemspringboot.repository.BookRepository;

@Repository
public class BookIssueDao {

	@Autowired
	private BookIssueRepository bookIssueRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private BookIssue bookIssue;

	/*
	 * BookIssue Save Method
	 */
	public BookIssue saveBookIssue(int studentId, int bookId) {

		Book book = bookDao.getBookById(bookId);

		Student student = studentDao.getStudentById(studentId);

		LocalDate localDate = LocalDate.now();

		localDate = localDate.plusDays(10);

		if ((student != null) && (book != null)) {

			bookIssue.setBookIssueId(bookId);

			bookIssue.setStudent(student);

			bookIssue.setBook(book);

			bookIssue.setBookSubmissionDate(localDate);

			bookIssueRepository.save(bookIssue);

			return bookIssue;
		} else {
			return null;
		}
	}

	/*
	 * submit the book issued by librarian
	 */
	public BookIssue submitIssuedBook(int bookId, int studentId) {

		Book book = bookDao.getBookById(bookId);

		Student student = studentDao.getStudentById(studentId);

		if ((student != null) && (book != null)) {

			Optional<BookIssue> optional = bookIssueRepository.findById(book.getBookNumber());

			if (optional.isPresent()) {
				bookIssue = optional.get();
				bookIssueRepository.delete(bookIssue);
				return bookIssue;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/*
	 * check the fine for late submission
	 */
	public BookIssue checkFineForLateSubmission(int bookId, int studentId) {

		Book book = bookDao.getBookById(bookId);

		Student student = studentDao.getStudentById(studentId);

		if ((student != null) && (book != null)) {

			Optional<BookIssue> optional = bookIssueRepository.findById(book.getBookNumber());

			if (optional.isPresent()) {

				BookIssue bookIssue = optional.get();

				LocalDate submissionDate = bookIssue.getBookSubmissionDate();

				int subDateValue = submissionDate.getDayOfMonth();

				int todayDateValue = LocalDate.now().getDayOfMonth();

				//todayDateValue = 25;
				
				if (todayDateValue > subDateValue) {
					int finalDateValue = todayDateValue - subDateValue;
					bookIssue.setFine(finalDateValue);
				}
				bookIssue.setBookSubmitDate(LocalDate.now());
				bookIssueRepository.save(bookIssue);
				return bookIssue;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}
}
