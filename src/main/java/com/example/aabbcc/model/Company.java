package com.example.aabbcc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    public Company(String location, Long companySize, String about, String founded, String industry, String websites) {
        this.location = location;
        this.companySize = companySize;
        this.about = about;
        this.founded = founded;
        this.industry = industry;
        this.websites = websites;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id ;

    private String location;
    private Long companySize;

    @Column(columnDefinition="TEXT")
    private String about;
    private String founded;
    private String industry;
    private String websites;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user2;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    List<CompanyJob> companyJobs = new ArrayList<>();

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", companySize=" + companySize +
                ", about='" + about + '\'' +
                ", founded='" + founded + '\'' +
                ", industry='" + industry + '\'' +
                ", websites='" + websites + '\'' +
                '}';
    }
}
