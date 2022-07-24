package com.example.aabbcc.services.impl;

import com.example.aabbcc.DTO.ApplicantPostDTO;
import com.example.aabbcc.mapper.PostMapper;
import com.example.aabbcc.model.Applicant;
import com.example.aabbcc.model.ApplicantPost;
import com.example.aabbcc.model.CompanyJob;
import com.example.aabbcc.model.User;
import com.example.aabbcc.repo.ApplicantPostRepo;
import com.example.aabbcc.repo.ApplicantRepo;
import com.example.aabbcc.repo.CompanyJobRepo;
import com.example.aabbcc.repo.UserRepo;
import com.example.aabbcc.services.ApplicantService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final CompanyJobRepo companyJobRepo;
    private final UserRepo userRepo;
    private final ApplicantPostRepo applicantPostRepo;
    private final ApplicantRepo applicantRepo;

    public ApplicantServiceImpl(CompanyJobRepo companyJobRepo, UserRepo userRepo, ApplicantPostRepo applicantPostRepo, ApplicantRepo applicantRepo) {
        this.companyJobRepo = companyJobRepo;
        this.userRepo = userRepo;
        this.applicantPostRepo = applicantPostRepo;

        this.applicantRepo = applicantRepo;
    }


    @Override
    public String deletePost(Long id) {
        applicantPostRepo.deleteById(id);
        return "null";
    }

    @Override
    public List<ApplicantPost> getPost(User user) {
        //System.out.println( user.getApplicant().getApplicantPosts());
        return user.getApplicant().getApplicantPosts();
    }

    @Override
    public List<CompanyJob> seeCompanyJobs() {
        return companyJobRepo.findAll();
    }

    @Override
    @Transactional
    public String saveApplicantPost(ApplicantPostDTO applicantPostDTO) {

        ApplicantPost applicantPost = PostMapper.ApplicantPostDTOToApplicantPost(applicantPostDTO);
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(userEmail);

        User user = userRepo.findByEmail(userEmail);
        Applicant applicant = user.getApplicant();

        applicantPost.setApplicant(applicant);
        applicant.getApplicantPosts().add(applicantPost);


        applicantPostRepo.save(applicantPost);
        applicantRepo.save(applicant);

        return "ok";
    }

    @Override
    public List<CompanyJob> searchCompanyJobs(String position) {
        return companyJobRepo.findByJobNameContains(position);
    }

}
