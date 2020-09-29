package com.gamingbaku.dao.impl;

import com.gamingbaku.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
    User findByNameAndSurname(String name, String surname);

    @Query(value = "select u from User u where u.email = ?1")
    User findByEmail(String alma);
}
