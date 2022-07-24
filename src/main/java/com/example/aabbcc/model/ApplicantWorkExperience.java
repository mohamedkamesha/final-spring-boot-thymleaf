package com.example.aabbcc.model;

import com.example.aabbcc.enumclass.JobTime;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ApplicantWorkExperience {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String position;
    private String companyName;
    @JsonFormat(pattern="yyyy-MM")
    private LocalDate start;
    @JsonFormat(pattern="yyyy-MM")
    private  LocalDate end;
    private JobTime jobTime;

    @ManyToOne
    @JsonIgnore
    private Applicant applicant;

}
