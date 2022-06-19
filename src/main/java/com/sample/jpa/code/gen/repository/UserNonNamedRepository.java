package com.sample.jpa.code.gen.repository;

import com.sample.jpa.code.gen.entity.User;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserNonNamedRepository {
  private EntityManager em;

  @Autowired
  public UserNonNamedRepository(@Qualifier("testWriteEntityManagerFactory") EntityManager em) {
    this.em = em;
  }

  public Optional<User> sampleCodegenInsertOptionalRecord(User user) {
    String sp = "dbo.sample_codegen_insert";
    var query = em.createStoredProcedureQuery(sp, User.class);

    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);

    query.setParameter(1, user.getId());
    query.setParameter(2, user.getUsername());
    query.setParameter(3, user.getAge());

    try{
      var result = query.getSingleResult();
      return Optional.of((User)result);
    }
    catch(NoResultException e){
      return Optional.empty();
    }
  }
  public User sampleCodegenInsertRecord(User user) {
    String sp = "dbo.sample_codegen_insert";
    var query = em.createStoredProcedureQuery(sp, User.class);

    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);

    query.setParameter(1, user.getId());
    query.setParameter(2, user.getUsername());
    query.setParameter(3, user.getAge());

    try{
      var result = query.getSingleResult();
      return (User)result;
    }
    catch(NoResultException e){
      return null;
    }
  }

  public List<User> sampleCodegenSelectRecords(int id, String username) {
    String sp = "dbo.sample_codegen_select";
    var query = em.createStoredProcedureQuery(sp, User.class);

    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);

    var result = query.getResultList();
    return result;

  }
  public Optional<User> sampleCodegenSelectOptionalRecord(int id, String username) {
    String sp = "dbo.sample_codegen_select";
    var query = em.createStoredProcedureQuery(sp, User.class);

    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);

    try{
      var result = query.getSingleResult();
      return Optional.of((User)result);
    }
    catch(NoResultException e){
      return Optional.empty();
    }
  }
  public User sampleCodegenSelectRecord(int id, String username) {
    String sp = "dbo.sample_codegen_select";
    var query = em.createStoredProcedureQuery(sp, User.class);

    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);

    try{
      var result = query.getSingleResult();
      return (User)result;
    }
    catch(NoResultException e){
      return null;
    }
  }
}
