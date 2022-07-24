package com.example.aabbcc.services;


import com.example.aabbcc.DTO.CompanyJobDTO;
import com.example.aabbcc.model.*;

import java.util.List;

public interface CompanyService {

    List<CompanyJob> getJobs(User user);
    String addJob(CompanyJobDTO companyJobDTO);
    List<ApplicantPost> seePost();
    List<Apply> seeCv(Long id);
    String deleteJob(Long id);
    List<Applicant> search(String position);
}
