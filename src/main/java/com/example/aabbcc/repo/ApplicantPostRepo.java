package com.example.aabbcc.repo;

import com.example.aabbcc.model.ApplicantPost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantPostRepo extends JpaRepository<ApplicantPost, Long> {
}
