package com.jsp.librarymanagementsystemspringboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mainadmin")
public class Admin {
	
	@Id
	@Column(name = "adminid")
	private int adminId;
	@Column(name = "adminname")
	private String adminName;
	@Column(name = "adminemail")
	private String adminEmail;
	@Column(name = "adminphone")
	private String adminPhone;

}
