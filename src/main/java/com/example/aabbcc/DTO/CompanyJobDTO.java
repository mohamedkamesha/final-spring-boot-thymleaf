package com.example.aabbcc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyJobDTO {


    private String jobName;
    private String jobTime;
    private String experience;
    private String requirements;
    private String description;


    @Override
    public String toString() {
        return "CompanyJobDTO{" +
                "jobName='" + jobName + '\'' +
                ", jobTime='" + jobTime + '\'' +
                ", experience='" + experience + '\'' +
                ", requirements='" + requirements + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
