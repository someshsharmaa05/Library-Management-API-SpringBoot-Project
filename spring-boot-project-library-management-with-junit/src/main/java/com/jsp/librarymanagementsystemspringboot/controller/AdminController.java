package com.jsp.librarymanagementsystemspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.librarymanagementsystemspringboot.dto.Admin;
import com.jsp.librarymanagementsystemspringboot.dto.ResponseStructure;
import com.jsp.librarymanagementsystemspringboot.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@RestController
public class AdminController extends HttpServlet{

	@Autowired
	HttpServletRequest httpServletRequest;

	@Autowired
	HttpSession httpSession ;

	@Autowired
	AdminService adminService;

	@PostMapping(value = "/saveAdmin")
	@Operation(
			description = "save Admin Details",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Successfully Admin Data Added",
							content = @Content(
									mediaType = "application/json",
									examples = {
											@ExampleObject(
													
													value = "{\"code\":200,\"Status\":ok!,\"Message\":\"Successfully Data Added\"}"
													
											)
								
									}
							)
					),
					@ApiResponse(
							responseCode = "400",
							description = "Bad Request!",
							content = @Content(
									mediaType = "application/json",
									examples = {
											@ExampleObject(
													
													value = "{\"code\":400,\"Status\":Bad Request!,\"Message\":\"Bad Request!\"}"
													
											)
								
									}
							)
					),
					
					@ApiResponse(
							responseCode = "500",
							description = "Internel Server Error!",
							content = @Content(
									mediaType = "application/json",
									examples = {
											@ExampleObject(
													
													value = "{\"code\":500,\"Status\":Internel Server Error!,\"Message\":\"Internel Server Error!\"}"
													
											)
								
									}
							)
					)
					
			}
			)
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}

	@GetMapping(value = "/loginAdmin/{adminName}/{adminEmail}")
	public String loginAdmin(@PathVariable String adminName, @PathVariable String adminEmail) {

		List<Admin> admins = adminService.getAllAdmins();

		for (Admin admin : admins) {
			
			if((admin.getAdminName().equalsIgnoreCase(adminName))&&(admin.getAdminEmail().equalsIgnoreCase(adminEmail))) {
				
				httpSession.setAttribute("adminEmail", adminName);
				
				return "admin logged in successfully";
				
			}else {
				return "Please Check Your UserName and Password";
			}
		}
		return null;
	}
	
	@GetMapping(value = "/logoutAdmin")
	public String logoutAdmin() {
		
		if(httpSession.getAttribute("adminEmail")!=null){
			
			httpSession.invalidate();
			
			return "admin logout successfully";
		}else {
			return "please login again then logout";
		}
	}
}
