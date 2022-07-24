package com.example.aabbcc.model;

import com.example.aabbcc.enumclass.JobTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyJob {

    public CompanyJob(String jobName, JobTime jobTime, String experience, LocalDate dateCreation, String description, List<JobRequirement> jobRequirements) {
        this.jobName = jobName;
        this.jobTime = jobTime;
        this.experience = experience;
        this.dateCreation = dateCreation;
        this.description = description;
        this.jobRequirements = jobRequirements;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String jobName;
    private JobTime jobTime;
    private String experience;
    private LocalDate dateCreation;
    @Column(columnDefinition="TEXT")
    private String description;

    @OneToMany(mappedBy = "companyJob")
    private List<JobRequirement> jobRequirements = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private Company company;


    @OneToMany(mappedBy = "companyJob",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Apply> cvs = new ArrayList<>();


    @Override
    public String toString() {
        return "CompanyJob{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobTime=" + jobTime +
                ", experience='" + experience + '\'' +
                ", dateCreation=" + dateCreation +
                ", description='" + description + '\'' +
                ", jobRequirements=" + jobRequirements +
                ", company=" + company +
                '}';
    }
}
