package com.example.aabbcc.DTO;

import com.example.aabbcc.enumclass.JobTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantPostDTO {

    private String jobName;
    private String experience;
    private String description;
    private String jobTime = JobTime.FullTime.toString() ;

    @Override
    public String toString() {
        return "ApplicantPostDTO{" +
                "jobName='" + jobName + '\'' +
                ", experience='" + experience + '\'' +
                ", description='" + description + '\'' +
                ", jobTime='" + jobTime + '\'' +
                '}';
    }
}
