package com.sample.jpa.code.gen.repository;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class UserNameWoutDtoRepository {
  private EntityManager em;

  @Autowired
  public UserNameWoutDtoRepository(@Qualifier("testWriteEntityManagerFactory") EntityManager em) {
    this.em = em;
  }


  public Optional<String> sampleCodegenInsertWithoutDtoValueOpt(int id, String username, int age) {
    String sp = "dbo.sample_codegen_insertwithoutdto";

    var query = em.createStoredProcedureQuery(sp);
    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);
    query.setParameter(3, age);

    query.execute();

    try{
      var result = query.getSingleResult();
      return Optional.of((String)result);
    }
    catch(NoResultException e){
      return Optional.empty();
    }
  }
  public String sampleCodegenInsertWithoutDtoValue(int id, String username, int age) {
    String sp = "dbo.sample_codegen_insertwithoutdto";

    var query = em.createStoredProcedureQuery(sp);
    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);
    query.setParameter(3, age);

    query.execute();

    try{
      var result = query.getSingleResult();
      return (String)result;
    }
    catch(NoResultException e){
      return null;
    }
  }

  public void sampleCodegenInsertWithoutDtoVoid(int id, String username, int age) {
    String sp = "dbo.sample_codegen_insertwithoutdto";

    var query = em.createStoredProcedureQuery(sp);
    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);
    query.setParameter(3, age);

    query.execute();

    return;
  }

  public Optional<String> sampleCodegenSelectWithoutDtoValueOpt(int id, String username) {
    String sp = "dbo.sample_codegen_selectwithoutdto";

    var query = em.createStoredProcedureQuery(sp);
    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);

    query.execute();

    try{
      var result = query.getSingleResult();
      return Optional.of((String)result);
    }
    catch(NoResultException e){
      return Optional.empty();
    }
  }

  public String sampleCodegenSelectWithoutDtoValue(Integer id, String username) {
    String sp = "dbo.sample_codegen_selectwithoutdto";

    var query = em.createStoredProcedureQuery(sp);
    query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
    query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);

    query.setParameter(1, id);
    query.setParameter(2, username);

    query.execute();

    try{
      var result = query.getSingleResult();
      return (String)result;
    }
    catch(NoResultException e){
      return null;
    }
  }
}
