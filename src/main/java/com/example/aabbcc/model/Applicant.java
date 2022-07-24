package com.example.aabbcc.model;

import com.example.aabbcc.enumclass.Gender;
import com.example.aabbcc.enumclass.MilitaryStatus;
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
public class Applicant{

    public Applicant(String address, LocalDate birthday, String position, String phone, String experience, String educationLevel, Gender gender, String about, MilitaryStatus militaryStatus) {
        this.address = address;
        this.birthday = birthday;
        this.position = position;
        this.phone = phone;
        this.experience = experience;
        this.educationLevel = educationLevel;
        this.gender = gender;
        this.about = about;
        this.militaryStatus = militaryStatus;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id ;
    private String address;


    private LocalDate birthday;

    private String position;
    private String phone;
    private String experience;
    private String educationLevel;
    private Gender gender;
    @Column(columnDefinition="TEXT")
    private String about;
    private MilitaryStatus militaryStatus;

    @OneToMany(mappedBy = "applicant")
    private List<ApplicantWorkExperience> applicantWorkExperiences = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    private User user1;

    @OneToMany(mappedBy = "applicant")
    @JsonIgnore
    private List<Apply> applies = new ArrayList<>();

    @OneToMany (mappedBy = "applicant")
    private List<ApplicantPost> applicantPosts = new ArrayList<>();

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", experience='" + experience + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", gender=" + gender +
                ", about='" + about + '\'' +
                ", militaryStatus=" + militaryStatus +
                '}';
    }
}
