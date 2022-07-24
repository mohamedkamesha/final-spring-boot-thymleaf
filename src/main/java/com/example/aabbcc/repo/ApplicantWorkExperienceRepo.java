package com.example.aabbcc.repo;

import com.example.aabbcc.model.ApplicantWorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantWorkExperienceRepo extends JpaRepository<ApplicantWorkExperience,Long > {
}
