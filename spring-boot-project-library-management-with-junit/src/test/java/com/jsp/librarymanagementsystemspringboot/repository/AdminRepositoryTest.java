package com.jsp.librarymanagementsystemspringboot.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.jsp.librarymanagementsystemspringboot.dto.Admin;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminRepositoryTest {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setup() {

		Admin admin = new Admin(123, "ansari", "ansari@gmail.com", "9651076292");
		entityManager.persist(admin);
	}

	@Test
	public void testSaveAdmin() {

		Admin admin = adminRepository.findById(123).get();

		Assert.assertEquals("ansari", admin.getAdminName());
	}

	/*
	 * The same test cases we can write with assertthat() methods
	 */

	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveAdminTest() {

		Admin admin = Admin.builder().adminId(456).adminName("nazim").adminEmail("nazim@gmail.com")
				.adminPhone("3245678").build();
		adminRepository.save(admin);

		Assertions.assertThat(!(admin.getAdminName().isEmpty()));
	}

	@Test
	@Order(2)
	public void getAdminById() {

		Admin admin = adminRepository.findById(123).get();

		Assertions.assertThat(admin.getAdminId()).isEqualTo(123);
	}

	@Test
	@Order(3)
	public void getAllAdmin() {
		List<Admin> admins = adminRepository.findAll();

		Assertions.assertThat(admins.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateAdmin() {

		Admin admin = adminRepository.findById(123).get();

		admin.setAdminEmail("naziya@gmail.com");

		Admin admin2 = adminRepository.save(admin);

		Assertions.assertThat(admin.getAdminEmail()).isEqualTo("naziya@gmail.com");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteAdmin() {
		
		Admin admin = adminRepository.findById(123).get();

		adminRepository.delete(admin);
		
		Admin admin2 = null;
		
		Optional<Admin> optional = adminRepository.findByAdminEmail("naziya@gmail.com");
		
		if(optional.isPresent()) {
			admin2=optional.get();
		}
		
		Assertions.assertThat(admin2).isNull();
	}
}
