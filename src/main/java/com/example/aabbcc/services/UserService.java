package com.example.aabbcc.services;

import com.example.aabbcc.DTO.UserApplicantDTO;
import com.example.aabbcc.DTO.UserCompanyDTO;
import com.example.aabbcc.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

     User saveAccount(UserCompanyDTO userCompanyDTO);
     User saveApplicant(UserApplicantDTO userApplicantDTO);

}
