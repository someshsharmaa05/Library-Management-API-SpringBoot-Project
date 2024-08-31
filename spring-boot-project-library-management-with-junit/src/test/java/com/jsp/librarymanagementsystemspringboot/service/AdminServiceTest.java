package com.jsp.librarymanagementsystemspringboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jsp.librarymanagementsystemspringboot.repository.AdminRepository;

@SpringBootTest
class AdminServiceTest {

	@Autowired
	private AdminService adminService;
	
	@MockBean
	private AdminRepository adminRepository; 
	
	@Test
	public void testAdminSave() {
		
	}

}
