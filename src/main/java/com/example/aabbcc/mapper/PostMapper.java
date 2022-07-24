package com.example.aabbcc.mapper;

import com.example.aabbcc.DTO.ApplicantPostDTO;
import com.example.aabbcc.enumclass.JobTime;
import com.example.aabbcc.model.ApplicantPost;


import java.time.LocalDate;

public class PostMapper {
    public static ApplicantPost ApplicantPostDTOToApplicantPost(ApplicantPostDTO applicantPostDTO){
        System.out.println(applicantPostDTO);
        ApplicantPost applicantPost = new ApplicantPost();
        applicantPost.setJobName(applicantPostDTO.getJobName());
        applicantPost.setDescription(applicantPostDTO.getDescription());
        applicantPost.setJobTime(JobTime.valueOf(applicantPostDTO.getJobTime()));
        applicantPost.setExperience(applicantPostDTO.getExperience());
        applicantPost.setDateCreation(LocalDate.now());



        return applicantPost;
    }
}
