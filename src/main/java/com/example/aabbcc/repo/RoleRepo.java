package com.example.aabbcc.repo;


import com.example.aabbcc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RoleRepo extends JpaRepository<Role,Long> {
}
