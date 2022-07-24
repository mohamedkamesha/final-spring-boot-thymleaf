package com.example.aabbcc.services.impl;

import com.example.aabbcc.DTO.AccountApplicant;
import com.example.aabbcc.DTO.AccountCompany;
import com.example.aabbcc.DTO.UserApplicantDTO;
import com.example.aabbcc.DTO.UserCompanyDTO;
import com.example.aabbcc.mapper.UserMapper;
import com.example.aabbcc.model.Applicant;
import com.example.aabbcc.model.Company;
import com.example.aabbcc.model.Role;
import com.example.aabbcc.model.User;
import com.example.aabbcc.repo.ApplicantRepo;
import com.example.aabbcc.repo.CompanyRepo;
import com.example.aabbcc.repo.RoleRepo;
import com.example.aabbcc.repo.UserRepo;
import com.example.aabbcc.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServicesImpl implements UserService {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final CompanyRepo companyRepo;
    private final RoleRepo roleRepo;
    private final ApplicantRepo applicantRepo;

    public UserServicesImpl(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder, CompanyRepo companyRepo, RoleRepo roleRepo, ApplicantRepo applicantRepo) {
        this.userRepo = userRepo;

        this.passwordEncoder = passwordEncoder;
        this.companyRepo = companyRepo;
        this.roleRepo = roleRepo;
        this.applicantRepo = applicantRepo;
    }




    @Override
    @Transactional
    public User saveAccount(UserCompanyDTO userCompanyDTO) {
        AccountCompany accountCompany = UserMapper.UserCompanyDTOToAccountCompany(userCompanyDTO);
        System.out.println(accountCompany.getCompany());
        System.out.println(accountCompany.getUser());
        String s= passwordEncoder.encode(accountCompany.getUser().getPassword());

        User user = accountCompany.getUser();

        Role role = new Role();
        role.setRole("user");
        role.setUser(user);
        user.getRoles().add(role);


        Company company = accountCompany.getCompany();

        user.setPassword(s);


        userRepo.save(user);
        roleRepo.save(role);
        companyRepo.save(company);

        return null;
    }

    @Override
    @Transactional
    public User saveApplicant(UserApplicantDTO userApplicantDTO) {
        AccountApplicant accountApplicant = UserMapper.UserApplicantDTOToAccountApplicant(userApplicantDTO);
        String s= passwordEncoder.encode(accountApplicant.getUser().getPassword());
        System.out.println(accountApplicant.getApplicant());
        System.out.println(accountApplicant.getUser());


        User user = accountApplicant.getUser();

        Role role = new Role();
        role.setRole("user");
        role.setUser(user);
        user.getRoles().add(role);


        Applicant applicant = accountApplicant.getApplicant();

        user.setPassword(s);


        userRepo.save(user);
        roleRepo.save(role);
        applicantRepo.save(applicant);



        return null;
    }


}
