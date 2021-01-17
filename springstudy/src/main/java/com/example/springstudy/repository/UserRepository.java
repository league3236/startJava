package com.example.springstudy.repository;

import com.example.springstudy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByPhoneNumberOrderByIdDesc(String PhoneNumber);


}
