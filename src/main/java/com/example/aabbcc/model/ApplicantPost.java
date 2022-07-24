package com.example.aabbcc.model;


import com.example.aabbcc.enumclass.JobTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String jobName;
    private JobTime jobTime;
    private String experience;
    private LocalDate dateCreation;
    @Column(columnDefinition="TEXT")
    private String description;
    private String cvName;

    @ManyToOne
    @JsonIgnore
    private Applicant applicant;

    @Override
    public String toString() {
        return "ApplicantPost{" +
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobTime=" + jobTime +
                ", experience='" + experience + '\'' +
                ", dateCreation=" + dateCreation +
                ", description='" + description + '\'' +
                '}';
    }
}
