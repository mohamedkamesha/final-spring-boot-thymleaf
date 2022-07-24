package com.example.aabbcc.repo;


import com.example.aabbcc.model.CompanyJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyJobRepo extends JpaRepository<CompanyJob, Long> {

    List<CompanyJob> findByJobNameContains (String jobName);
}
