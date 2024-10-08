package com.jsp.librarymanagementsystemspringboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.librarymanagementsystemspringboot.dto.Admin;
import com.jsp.librarymanagementsystemspringboot.repository.AdminRepository;

/*
 * jbsfjbskhjkbkdjb
 */

@Repository
public class AdminDao {

	/*
	 * 
	 */
	@Autowired
	AdminRepository adminRepository;
	
	/*
	 * 
	 */
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}
	
	/*
	 * thids method will fetch all the data from mainadmin table
	 */
	public List<Admin> getAllAdmins(){
		
		return adminRepository.findAll();
	}
}
