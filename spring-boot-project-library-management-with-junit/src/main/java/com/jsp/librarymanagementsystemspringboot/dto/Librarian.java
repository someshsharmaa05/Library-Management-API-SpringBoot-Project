package com.jsp.librarymanagementsystemspringboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "librarian")
@Data
public class Librarian {

	@Id
	@Column(name = "librarianid")
	private int librarianId;
	@Column(name = "librarianname")
	private String librarianName;
	@Column(name = "librarianemail")
	private String librarianEmail;


}
