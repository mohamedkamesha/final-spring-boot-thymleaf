package com.example.aabbcc.mapper;

import com.example.aabbcc.DTO.CompanyJobDTO;
import com.example.aabbcc.enumclass.JobTime;
import com.example.aabbcc.model.CompanyJob;
import com.example.aabbcc.model.JobRequirement;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompanyMapper {
    public static CompanyJob companyJobDTOToCompanyJob(CompanyJobDTO companyJobDTO){

        List<JobRequirement> jobRequirements = new ArrayList<>();
        CompanyJob companyJob = new CompanyJob(
                companyJobDTO.getJobName(), JobTime.valueOf(companyJobDTO.getJobTime()),
                companyJobDTO.getExperience(), LocalDate.now(), companyJobDTO.getDescription(),
                null);


        JobRequirement jobRequirement = new JobRequirement(companyJobDTO.getRequirements(),companyJob) ;
        jobRequirements.add(jobRequirement);

        companyJob.setJobRequirements(jobRequirements);



        return  companyJob;
    }

}
