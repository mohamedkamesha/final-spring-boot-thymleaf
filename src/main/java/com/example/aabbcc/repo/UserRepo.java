package com.example.aabbcc.repo;


import com.example.aabbcc.enumclass.Type;
import com.example.aabbcc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository< User,Long> {

    User findByEmail(String email);
    Boolean existsByEmail(String email);
    List<User> findByTypeAndApplicantPosition(Type type , String position);




}
