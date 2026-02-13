package com.chom.teluskospringsecurity6withspringbootjwttutorial.Repositories;

import com.chom.teluskospringsecurity6withspringbootjwttutorial.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRep extends JpaRepository<User, Integer> {

    List<User> findUsersByUsername(String username);

    User findByUsername(String username);
}
