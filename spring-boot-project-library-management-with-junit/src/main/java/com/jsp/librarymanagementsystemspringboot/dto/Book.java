package com.jsp.librarymanagementsystemspringboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

	@Id
	@Column(name = "booknumber")
	private int bookNumber;
	@Column(name = "bookname")
	private String bookName;
	@Column(name = "bookauthor")
	private String bookAuthor;
	
	@ManyToOne()
	@JoinColumn(name = "studentid")
	private Student student;
	
	
}
