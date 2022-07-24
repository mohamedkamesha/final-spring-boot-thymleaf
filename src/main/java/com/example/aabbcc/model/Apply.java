package com.example.aabbcc.model;

import com.example.aabbcc.enumclass.JopApplyStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Apply {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cvName;
    private Integer cvRank;
    private JopApplyStatus jopApplyStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Applicant applicant;

    @ManyToOne
    @JsonIgnore
    private CompanyJob companyJob;


}
