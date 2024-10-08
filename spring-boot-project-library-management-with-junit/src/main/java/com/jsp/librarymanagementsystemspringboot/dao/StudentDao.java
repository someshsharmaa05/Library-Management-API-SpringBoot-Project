package com.jsp.librarymanagementsystemspringboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagementsystemspringboot.dto.Student;
import com.jsp.librarymanagementsystemspringboot.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	StudentRepository repository;
	
	public void saveStudent(Student student) {
		
		repository.save(student);
	}
	
	public Student getStudentById(int studentId) {
		
		return repository.findById(studentId).get();
	}
	
//	public Student deleteStudent(int studentid) {
//		Student student = repository.findById(studentid).get();
//		
//		 
//	}
}
