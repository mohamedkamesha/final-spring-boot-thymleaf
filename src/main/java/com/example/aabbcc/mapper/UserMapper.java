package com.example.aabbcc.mapper;

import com.example.aabbcc.DTO.AccountApplicant;
import com.example.aabbcc.DTO.AccountCompany;
import com.example.aabbcc.DTO.UserApplicantDTO;
import com.example.aabbcc.DTO.UserCompanyDTO;
import com.example.aabbcc.enumclass.Gender;
import com.example.aabbcc.enumclass.MilitaryStatus;
import com.example.aabbcc.enumclass.Type;
import com.example.aabbcc.model.Applicant;
import com.example.aabbcc.model.Company;
import com.example.aabbcc.model.Role;
import com.example.aabbcc.model.User;

import java.time.LocalDate;


public class  UserMapper {

  public static AccountApplicant UserApplicantDTOToAccountApplicant(UserApplicantDTO userApplicantDTO){
    Type type = Type.applicant;
    Gender gender = Gender.valueOf(userApplicantDTO.getGender());
    MilitaryStatus militaryStatus = MilitaryStatus.valueOf(userApplicantDTO.getMilitaryStatus());
    User user = new User(
            userApplicantDTO.getName(),userApplicantDTO.getEmail(), userApplicantDTO.getPassword(),
             type,userApplicantDTO.getImage(),userApplicantDTO.getFacebookLink(),
            userApplicantDTO.getGithubLink(), userApplicantDTO.getLinkedInLink());


    LocalDate localDate = LocalDate.parse(userApplicantDTO.getBirthday());
    Applicant applicant = new Applicant(
            userApplicantDTO.getAddress(),localDate, userApplicantDTO.getPosition(),
            userApplicantDTO.getPhone(),userApplicantDTO.getExperience(),userApplicantDTO.getEducationLevel(),
             gender,userApplicantDTO.getAbout(),militaryStatus);


    user.setApplicant(applicant);
    user.setCompany(null);

    applicant.setUser1(user);

    AccountApplicant accountApplicant = new AccountApplicant(user,applicant) ;

    return accountApplicant;
  }


  public static AccountCompany UserCompanyDTOToAccountCompany(UserCompanyDTO userCompanyDTO){
    Type type = Type.company;
    User user = new User(userCompanyDTO.getName(), userCompanyDTO.getEmail(), userCompanyDTO.getPassword(),
            type, userCompanyDTO.getImage(), userCompanyDTO.getFacebookLink(), userCompanyDTO.getGithubLink(), userCompanyDTO.getLinkedInLink());



    Company company = new Company(
            userCompanyDTO.getLocation(), userCompanyDTO.getCompanySize(),userCompanyDTO.getAbout(),
            userCompanyDTO.getFounded(), userCompanyDTO.getIndustry(), userCompanyDTO.getWebsites() );

    user.setApplicant(null);
    user.setCompany(company);

    company.setUser2(user);
    AccountCompany accountCompany = new AccountCompany(user,company);
    return accountCompany;
  }




}
