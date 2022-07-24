package com.example.aabbcc.model;

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
public class JobRequirement {

    public JobRequirement(String requirement, CompanyJob companyJob) {
        this.requirement = requirement;
        this.companyJob = companyJob;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String requirement;

    @ManyToOne
    @JsonIgnore
    private CompanyJob companyJob;

    @Override
    public String toString() {
        return "JobRequirement{" +
                "id=" + id +
                ", requirement='" + requirement + '\'' +
                '}';
    }
}
