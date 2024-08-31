package com.jsp.librarymanagementsystemspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.dto.Student;
import com.jsp.librarymanagementsystemspringboot.service.StudentService;

@RestController
public class StudentController {

	
	@Autowired
	StudentService studentService;
	/*
	 * SaveMethod For Student You Can Save The Data once You will login 
	 * with the librarian
	 */
	@PostMapping("/saveStudent")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student){
		
		return studentService.saveStudent(student);
	}
}
