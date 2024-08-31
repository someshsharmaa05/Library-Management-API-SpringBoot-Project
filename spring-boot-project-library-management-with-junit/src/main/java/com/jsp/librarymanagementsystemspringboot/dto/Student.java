package com.jsp.librarymanagementsystemspringboot.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	@Id
	@Column(name = "studentid")
	private int studentId;
	@Column(name = "studentname")
	private String studentName;
	@Column(name = "studentemail")
	private String studentEmail;
	@Column(name = "studentphone")
	private long studentPhone;
	
	@OneToMany(mappedBy = "student")
	private List<Book> books;
	
}
