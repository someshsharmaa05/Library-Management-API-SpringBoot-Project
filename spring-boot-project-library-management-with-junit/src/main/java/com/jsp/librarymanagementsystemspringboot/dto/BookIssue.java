package com.jsp.librarymanagementsystemspringboot.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "issuebook")
@Component
public class BookIssue implements Serializable {

	@Id
	@Column(name = "bookissueid")
	private int bookIssueId;
	@UpdateTimestamp
	@Column(name="bookissuedate")
	private LocalDate bookIssueDate;
	@Column(name="booksubmissiondate")
	private LocalDate bookSubmissionDate;
	@Column(name="booksubmitdate")
	private LocalDate bookSubmitDate;
	private int fine;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name="studentid")
	private Student student;
	@OneToOne
	@JsonIgnore
	@JoinColumn(name = "bookid")
	private Book book;
}
