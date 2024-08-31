package com.jsp.librarymanagementsystemspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.librarymanagementsystemspringboot.dao.LibrariranDao;
import com.jsp.librarymanagementsystemspringboot.dto.Librarian;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/*
 * 
 */
@SuppressWarnings("serial")
@Service
public class LibrarianService extends HttpServlet {

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	HttpSession httpSession;

	/*
	 * 
	 */
	@Autowired
	LibrariranDao dao;

	@Autowired
	ResponseStructure<Librarian> responseStructure;

	/*
	 * 
	 */
	public ResponseStructure<Librarian> saveLibrarian(Librarian librarian) {

		if (httpSession.getAttribute("adminEmail") != null) {

			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMsg("Librarian-Data-Added");
			responseStructure.setData(librarian);
			dao.saveLibrarian(librarian);
			return responseStructure;

		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Please-Login-With-Admin");
			responseStructure.setData(null);
			return responseStructure;
		}
	}

	/*
	 * update method to update any data of librarian
	 */
	public ResponseStructure<Librarian> updateLibrarian(Librarian librarian, int librarianId) {

		if (httpSession.getAttribute("adminEmail") != null) {

			Librarian librarian2 = dao.updateLibrarian(librarian, librarianId);

			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Data-Updated-Successfully...");
			responseStructure.setData(librarian2);
			return responseStructure;
		} else {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Please Login With Admin And then update...");
			responseStructure.setData(null);
			return responseStructure;
		}
	}

	public List<Librarian> getAllLibrariansData() {

		return dao.getAllLibrariansData();
	}
}
