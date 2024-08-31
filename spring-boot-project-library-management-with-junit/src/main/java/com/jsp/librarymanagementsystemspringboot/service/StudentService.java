package com.jsp.librarymanagementsystemspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagementsystemspringboot.dao.StudentDao;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.dto.Student;

import jakarta.servlet.http.HttpSession;

@Service
public class StudentService {

	@Autowired
	HttpSession httpSession;

	@Autowired
	StudentDao studentDao;

	@Autowired
	ResponseStructure<Student> responseStructure;

	/*
	 * saveMethod For Student
	 */
	public ResponseStructure<Student> saveStudent(Student student) {

		if (httpSession.getAttribute("librarianEmail") != null) {

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Inserted.....");
			responseStructure.setData(student);
			studentDao.saveStudent(student);
			return responseStructure;

		} else {

			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please-Login-With-Librarian-And-Then-Add");
			responseStructure.setData(student);

			return responseStructure;
		}

	}

	/*
	 * getStudentById method
	 */
	public ResponseStructure<Student> getStudentById(int studentId) {

		if (httpSession.getAttribute("librarianEmail") != null) {

			Student student=studentDao.getStudentById(studentId);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Present....");
			responseStructure.setData(student);
			return responseStructure;

		} else {

			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Please-Login-With-Librarian");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
}
