package com.gamingbaku.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.gamingbaku.dao.inter.UserDaoInter;
import com.gamingbaku.entity.User;
import com.gamingbaku.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//service class-larini yaratmaqda meqsed @Transactional lazim olduqda bu classi cagirmagdir
@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDao1")
    private UserDaoInter userDao;

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
