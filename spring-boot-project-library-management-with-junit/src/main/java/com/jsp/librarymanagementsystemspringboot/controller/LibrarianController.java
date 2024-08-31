package com.jsp.librarymanagementsystemspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagementsystemspringboot.dto.Librarian;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.service.LibrarianService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
public class LibrarianController {

	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	LibrarianService  librarianService;
	
	@PostMapping(value = "/saveLibrarian")
	public ResponseStructure<Librarian> saveLibrarian(@RequestBody Librarian librarian) {

		return librarianService.saveLibrarian(librarian);
	}
	
	@PutMapping("/updateLibrarian/{librarianId}")
	public ResponseStructure<Librarian> updateLibrarian(@RequestBody Librarian librarian, @PathVariable int librarianId) {
		return librarianService.updateLibrarian(librarian, librarianId);
	}
	
	@GetMapping("/logLibrarian/{librarianName}/{librarianEmail}")
	public String librarianLogin(@PathVariable String librarianName, @PathVariable String librarianEmail) {
		
		List<Librarian> librarians = librarianService.getAllLibrariansData();
		
		for (Librarian librarian : librarians) {
			
			if((librarian.getLibrarianEmail().equalsIgnoreCase(librarianEmail))&&(librarian.getLibrarianName().equalsIgnoreCase(librarianName))) {
				
				httpSession.setAttribute("librarianEmail", librarianEmail);
				
				return "Librarian Loggedin Success";
				
			}else {
				
				return "Please Check Your UserName and Password";
			}
		}
		return null;
	}
	
	/*
	 * librarian-Logout
	 */
	@GetMapping("/librarianLogout")
	public String logoutLibrarian() {
		
		httpSession.invalidate();
		
		return "librarian-logout-successfully!!!!!";
	}
}
