package com.example.aabbcc.services.impl;

import com.example.aabbcc.DTO.CompanyJobDTO;
import com.example.aabbcc.mapper.CompanyMapper;
import com.example.aabbcc.model.*;
import com.example.aabbcc.repo.*;
import com.example.aabbcc.services.CompanyService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class companyServiceImpl implements CompanyService {

    private final UserRepo userRepo;
    private final CompanyRepo companyRepo;
    private final CompanyJobRepo companyJobRepo;
    private final ApplicantPostRepo applicantPostRepo;
    private final ApplyRepo applyRepo;
    private final ApplicantRepo applicantRepo;

    public companyServiceImpl(UserRepo userRepo, CompanyRepo companyRepo, CompanyJobRepo companyJobRepo, ApplicantPostRepo applicantPostRepo, ApplyRepo applyRepo, ApplicantRepo applicantRepo) {
        this.userRepo = userRepo;
        this.companyRepo = companyRepo;
        this.companyJobRepo = companyJobRepo;
        this.applicantPostRepo = applicantPostRepo;
        this.applyRepo = applyRepo;
        this.applicantRepo = applicantRepo;
    }

    @Override
    public List<CompanyJob> getJobs(User user) {
        return user.getCompany().getCompanyJobs();
    }

    @Override
    public String addJob(CompanyJobDTO companyJobDTO) {

        CompanyJob companyJob = CompanyMapper.companyJobDTOToCompanyJob(companyJobDTO);
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(userEmail);

        User user = userRepo.findByEmail(userEmail);
        Company company = user.getCompany();
        company.getCompanyJobs().add(companyJob);
        companyJob.setCompany(company);

        companyJobRepo.save(companyJob);
        companyRepo.save(company);

        return "ok";
    }

    @Override
    public List<ApplicantPost> seePost() {
        return applicantPostRepo.findAll();
    }

    @Override
    public List<Apply> seeCv(Long id) {
        return applyRepo.findByCompanyJobIdAndCvRankNotNullOrderByCvRankDesc(id);
    }

    @Override
    public String deleteJob(Long id) {
        companyJobRepo.deleteById(id);
        return "null";
    }

    @Override
    public List<Applicant> search(String position) {
        return applicantRepo.findByPositionContains(position);
    }
}
