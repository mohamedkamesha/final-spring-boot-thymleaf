package com.example.aabbcc.repo;

import com.example.aabbcc.model.Applicant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant,Long> {

    List<Applicant>  findByPositionContains(String position);
}
