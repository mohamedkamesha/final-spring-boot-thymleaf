package com.example.aabbcc.services;

import com.example.aabbcc.DTO.ApplicantPostDTO;
import com.example.aabbcc.model.ApplicantPost;
import com.example.aabbcc.model.CompanyJob;
import com.example.aabbcc.model.User;

import java.util.List;

public interface ApplicantService {
    String deletePost(Long id) ;

    List<ApplicantPost> getPost(User user);

    List<CompanyJob> seeCompanyJobs();
    String saveApplicantPost(ApplicantPostDTO applicantPostDTO);

    List<CompanyJob> searchCompanyJobs(String position);
}
