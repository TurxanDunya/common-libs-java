package com.gamingbaku.dao.impl;

import com.gamingbaku.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;

    public List<User> getAll(String name, String surname) {
        String jpql = "select u from User u where 1=1";

        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }

        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }

        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }

        return query.getResultList();
    }

    @Override
    public User findByEmailAndPassword(String email, String password) { //CriteriaBuilder ile
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> q1 = cb.createQuery(User.class);
        Root<User> postRoot = q1.from(User.class);
        CriteriaQuery<User> q2 = q1
                .where(cb.equal(postRoot.get("email"), ":e"), cb.equal(postRoot.get("password"), ":p"));

        Query query = em.createQuery(q2);

//        query.setParameter(1, email);
//        query.setParameter(2, password);
        List<User> list = query.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    public boolean removeUser(final int id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    public User getById(int userId) {
        User u = em.find(User.class, userId);
        return u;
    }

    private static BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.encode(u.getPassword()));
        em.persist(u);
        return true;
    }

    @Override
    public User findByEmail(String email) {  //Native SQL
        Query query = em.createNativeQuery("select * from user where email= ?", User.class);
        query.setParameter(1, email);

        List<User> list = query.getResultList();
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
}
