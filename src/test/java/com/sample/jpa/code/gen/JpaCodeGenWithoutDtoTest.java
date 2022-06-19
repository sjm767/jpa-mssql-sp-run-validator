package com.sample.jpa.code.gen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sample.jpa.code.gen.entity.User;
import com.sample.jpa.code.gen.repository.UserRepository;
import com.sample.jpa.code.gen.repository.UserNameWoutDtoRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaCodeGenWithoutDtoTest {

  @Autowired
  private UserNameWoutDtoRepository userNameWoutDtoRepository;

  @Autowired
  private UserRepository userRepository;

  @Transactional
  @Test
  void testJpaInsertWithoutDtoValueOpt(){
    User user = User.createUser(1231,"test_user",10);
    Optional<String> result = userNameWoutDtoRepository.sampleCodegenInsertWithoutDtoValueOpt(user.getId(),user.getUsername(),user.getAge());
    assertEquals(result.get(),"SUCCESS");
  }
  @Transactional
  @Test
  void testJpaInsertWithoutDtoValue(){
    User user = User.createUser(1231,"test_user",10);
    String result = userNameWoutDtoRepository.sampleCodegenInsertWithoutDtoValue(user.getId(),user.getUsername(),user.getAge());
    assertEquals(result,"SUCCESS");
  }
  @Transactional
  @Test
  void testJpaInsertWithoutDtoVoid(){
    User user = User.createUser(1231,"test_user",10);
    userNameWoutDtoRepository.sampleCodegenInsertWithoutDtoVoid(user.getId(),user.getUsername(),user.getAge());

    var result = userRepository.sampleCodegenSelectRecord(user.getId(),user.getUsername());
    User userResult = result;

    assertEquals(userResult.getAge(),10);
  }
  @Transactional
  @Test
  void testJpaSelectWithoutDtoValueOpt(){
    User user = User.createUser(1231,"test_user",10);
    userNameWoutDtoRepository.sampleCodegenInsertWithoutDtoVoid(user.getId(),user.getUsername(),user.getAge());

    Optional<String> result = userNameWoutDtoRepository.sampleCodegenSelectWithoutDtoValueOpt(user.getId(),user.getUsername());

    assertEquals(result.get(),"VALUE_1");
  }

  @Transactional
  @Test
  void testJpaSelectWithoutDtoValue(){
    User user = User.createUser(1231,"test_user",10);
    userNameWoutDtoRepository.sampleCodegenInsertWithoutDtoVoid(user.getId(),user.getUsername(),user.getAge());

    String result = userNameWoutDtoRepository.sampleCodegenSelectWithoutDtoValue(user.getId(),user.getUsername());
    assertEquals(result,"VALUE_1");
  }




}
