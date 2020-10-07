package com.gamingbaku.dao.impl;

import com.gamingbaku.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom{

//    findByName - we are using here, must be reference to 'name' column in User entity
    User findByName(String name);

//    all must be declared as findBy...
    User findByNameAndSurname(String name, String surname);

//    @Query(value = "select u from User u where u.email = :email")
//    User findByEmail(@Param("email") String email);
}
