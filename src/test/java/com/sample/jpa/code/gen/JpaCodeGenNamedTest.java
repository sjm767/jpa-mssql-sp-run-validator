package com.sample.jpa.code.gen;

import com.sample.jpa.code.gen.entity.User;
import com.sample.jpa.code.gen.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JpaCodeGenNamedTest {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Test
	void testJpaInsertOptional(){
		User user = User.createUser(1231,"test_user",10);

		var result = userRepository.sampleCodegenInsertOptionalRecord(user);

		Assertions.assertEquals(result.get().getAge(),10);
	}
	@Transactional
	@Test
	void testJpaInsertRecord(){
		User user = User.createUser(1231,"test_user",10);
		var result = userRepository.sampleCodegenInsertRecord(user);

		Assertions.assertEquals(result.getAge(),10);
	}

	@Transactional
	@Test
	void testJpaSelectRecords(){
		User user = User.createUser(1231,"test_user",10);
		userRepository.sampleCodegenInsertRecord(user);

		var result = userRepository.sampleCodegenSelectRecords(user.getId(),user.getUsername());
		User userResult = result.get(0);

		assertEquals(userResult.getAge(),10);
	}
	@Transactional
	@Test
	void testJpaSelectNoRecords(){
		User user = User.createUser(1231,"test_user",10);
		userRepository.sampleCodegenInsertRecord(user);

		var result = userRepository.sampleCodegenSelectRecords(99,"test_user_99");
		assertTrue(result.size()==0);
	}
	@Transactional
	@Test
	void testJpaSelectOptionalRecord(){
		User user = User.createUser(1231,"test_user",10);
		userRepository.sampleCodegenInsertRecord(user);

		var result = userRepository.sampleCodegenSelectOptionalRecord(user.getId(),user.getUsername());
		Optional<User> userResult = result;

		assertEquals(userResult.get().getAge(),10);
	}
	@Transactional
	@Test
	void testJpaSelectOptionalNoRecord(){
		User user = User.createUser(1231,"test_user",10);
		userRepository.sampleCodegenInsertRecord(user);

		var result = userRepository.sampleCodegenSelectOptionalRecord(99,"test_user_n");
		assertTrue(result.isEmpty());
	}
	@Transactional
	@Test
	void testJpaSelectRecord(){
		User user = User.createUser(1231,"test_user",10);
		userRepository.sampleCodegenInsertRecord(user);

		var result = userRepository.sampleCodegenSelectRecord(user.getId(),user.getUsername());
		User userResult = result;

		assertEquals(userResult.getAge(),10);
	}

	@Transactional
	@Test
	void testJpaSelectNoRecord(){
		User user = User.createUser(1231,"test_user",10);
		userRepository.sampleCodegenInsertRecord(user);

		var result = userRepository.sampleCodegenSelectRecord(99,"test_user_n");
		assertNull(result);
	}

}
