package com.jsp.librarymanagementsystemspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "library-management-project",
				version = "1.0.0",
				description = "this project is for librarian",
				termsOfService = "mind your own code",
				contact = @Contact(
						name = "Somesh Sharma",
						email = "someshsharmaa05@gmail.com"
				),
				license = @License(
						name = "license",
						url = "library.com"
				)
		)
)
public class LibraryManagementSystemSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemSpringBootApplication.class, args);
	}

}
