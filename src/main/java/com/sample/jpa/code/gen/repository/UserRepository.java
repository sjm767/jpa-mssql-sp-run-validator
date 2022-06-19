package com.sample.jpa.code.gen.repository;

import com.sample.jpa.code.gen.entity.User;
import java.util.Optional;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepository {

    private EntityManager em;

    @Autowired
    public UserRepository(@Qualifier("testWriteEntityManagerFactory") EntityManager em) {
        this.em = em;
    }

    public User sampleCodegenInsertRecord(User user) {
        String sp = User.SPInsertName;
        var query = em.createNamedStoredProcedureQuery(sp);

        query.setParameter(1, user.getId());
        query.setParameter(2, user.getUsername());
        query.setParameter(3, user.getAge());
        query.execute();

        try{
            var result = query.getSingleResult();
            return (User)result;
        }
        catch(NoResultException e){
            return null;
        }
    }

    public Optional<User> sampleCodegenInsertOptionalRecord(User user) {
        String sp = User.SPInsertName;
        var query = em.createNamedStoredProcedureQuery(sp);

        query.setParameter(1, user.getId());
        query.setParameter(2, user.getUsername());
        query.setParameter(3, user.getAge());
        query.execute();

        try{
            var result = query.getSingleResult();
            return Optional.of((User)result);
        }
        catch(NoResultException e){
            return Optional.empty();
        }
    }

    public List<User> sampleCodegenSelectRecords(int id, String username) {
        String sp = User.SPName;
        var query = em.createNamedStoredProcedureQuery(sp);

        query.setParameter(1, id);
        query.setParameter(2, username);
        query.execute();

        var result = query.getResultList();
        return result;
    }

    public Optional<User> sampleCodegenSelectOptionalRecord(int id, String username) {
        String sp = User.SPName;
        var query = em.createNamedStoredProcedureQuery(sp);

        query.setParameter(1, id);
        query.setParameter(2, username);
        query.execute();

        try{
            var result = query.getSingleResult();
            return Optional.of((User)result);
        }
        catch(NoResultException e){
            return Optional.empty();
        }
    }


    public User sampleCodegenSelectRecord(int id, String username) {

        String sp = User.SPName;
        var query = em.createNamedStoredProcedureQuery(sp);
        query.setParameter(1, id);
        query.setParameter(2, username);
        query.execute();

        try{
            var result = query.getSingleResult();
            return (User)result;
        }
        catch(NoResultException e){
            return null;
        }
    }
}