package com.example.aabbcc.DTO;

import com.example.aabbcc.enumclass.Gender;
import com.example.aabbcc.enumclass.MilitaryStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserApplicantDTO {

    private String name;
    private String email;
    private String password;
    private String type;
    private String image;
    private String facebookLink;
    private String githubLink;
    private String LinkedInLink;

    private String address;
    @JsonFormat(pattern="yyyy-MM-dd")
    private String birthday;
    private String position;
    private String phone;
    private String experience;
    private String educationLevel;
    private String gender = Gender.Male.toString();
    private String about;
    private String militaryStatus = MilitaryStatus.NotApplicable.toString();


    @Override
    public String toString() {
        return "UserApplicantDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", facebookLink='" + facebookLink + '\'' +
                ", githubLink='" + githubLink + '\'' +
                ", LinkedInLink='" + LinkedInLink + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", experience='" + experience + '\'' +
                ", educationLevel='" + educationLevel + '\'' +
                ", gender='" + gender + '\'' +
                ", about='" + about + '\'' +
                ", militaryStatus='" + militaryStatus + '\'' +
                '}';
    }
}
