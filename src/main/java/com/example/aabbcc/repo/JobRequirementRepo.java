package com.example.aabbcc.repo;

import com.example.aabbcc.model.JobRequirement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRequirementRepo extends JpaRepository<JobRequirement,Long > {
}
