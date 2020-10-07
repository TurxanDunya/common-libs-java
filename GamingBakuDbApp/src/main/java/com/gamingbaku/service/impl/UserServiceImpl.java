package com.gamingbaku.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gamingbaku.dao.impl.UserRepositoryCustom;
import com.gamingbaku.entity.User;
import com.gamingbaku.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/* service class-larini yaratmaqda meqsed @Transactional lazim olduqda bu classi cagirmagdir
 Service classes do main works in project. Service classes use DAO classes.
 It doesn't mean Service classes always need DAO classes. But, sometimes need.
 We also wrote @Transactional above the class. Why? So, every time we need DAO, transactional must be open.
 But, in this case, Transactional has been opening only one time.
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao;

    public List<User> getAll(String name, String surname) {
        return userDao.getAll(name, surname);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) { //CriteriaBuilder ile
        return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    public boolean removeUser(final int id) {
        return userDao.removeUser(id);
    }

    public User getById(int userId) {
        return userDao.getById(userId);
    }

    private static final BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public User findByEmail(String email) {  //Native SQL
        return userDao.findByEmail(email);
    }
}
