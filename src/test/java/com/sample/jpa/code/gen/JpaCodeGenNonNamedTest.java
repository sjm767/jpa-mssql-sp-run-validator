package com.sample.jpa.code.gen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sample.jpa.code.gen.entity.User;
import com.sample.jpa.code.gen.repository.UserNonNamedRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaCodeGenNonNamedTest {

	@Autowired
	private UserNonNamedRepository userNonNamedRepository;

	@Transactional
	@Test
	void testJpaInsertOptional(){
		User user = User.createUser(1231,"test_user",10);

		var result = userNonNamedRepository.sampleCodegenInsertOptionalRecord(user);

		assertEquals(result.get().getAge(),10);
	}
	@Transactional
	@Test
	void testJpaInsertRecord(){
		User user = User.createUser(1231,"test_user",10);
		var result = userNonNamedRepository.sampleCodegenInsertRecord(user);

		assertEquals(result.getAge(),10);
	}

	@Transactional
	@Test
	void testJpaSelectRecords(){
		User user = User.createUser(1231,"test_user",10);
		userNonNamedRepository.sampleCodegenInsertRecord(user);

		var result = userNonNamedRepository.sampleCodegenSelectRecords(user.getId(),user.getUsername());
		User userResult = result.get(0);

		assertEquals(userResult.getAge(),10);
	}
	@Transactional
	@Test
	void testJpaSelectNoRecords(){
		User user = User.createUser(1231,"test_user",10);
		userNonNamedRepository.sampleCodegenInsertRecord(user);

		var result = userNonNamedRepository.sampleCodegenSelectRecords(99,"test_user_99");
		assertTrue(result.size()==0);
	}

	@Transactional
	@Test
	void testJpaSelectOptionalRecord(){
		User user = User.createUser(1231,"test_user",10);
		userNonNamedRepository.sampleCodegenInsertRecord(user);

		var result = userNonNamedRepository.sampleCodegenSelectOptionalRecord(user.getId(),user.getUsername());
		Optional<User> userResult = result;

		assertEquals(userResult.get().getAge(),10);
	}
	@Transactional
	@Test
	void testJpaSelectOptionalNoRecord(){
		User user = User.createUser(1231,"test_user",10);
		userNonNamedRepository.sampleCodegenInsertRecord(user);

		var result = userNonNamedRepository.sampleCodegenSelectOptionalRecord(99,"test_user_n");
		assertTrue(result.isEmpty());
	}
	@Transactional
	@Test
	void testJpaSelectRecord(){
		User user = User.createUser(1231,"test_user",10);
		userNonNamedRepository.sampleCodegenInsertRecord(user);

		var result = userNonNamedRepository.sampleCodegenSelectRecord(user.getId(),user.getUsername());
		User userResult = result;

		assertEquals(userResult.getAge(),10);
	}

	@Transactional
	@Test
	void testJpaSelectNoRecord(){
		User user = User.createUser(1231,"test_user",10);
		userNonNamedRepository.sampleCodegenInsertRecord(user);

		var result = userNonNamedRepository.sampleCodegenSelectRecord(99,"test_user_n");
		assertNull(result);
	}

}
