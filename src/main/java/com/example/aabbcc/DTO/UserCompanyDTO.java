package com.example.aabbcc.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCompanyDTO {

    private String name;
    private String email;
    private String password;
    private String type;
    private String founded;
    private String industry;
    private String websites;


    private String facebookLink;
    private String githubLink;
    private String LinkedInLink;

    private String location;
    private Long companySize;
    private String about;

    private String image;

    @Override
    public String toString() {
        return "UserCompanyDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", founded='" + founded + '\'' +
                ", industry='" + industry + '\'' +
                ", websites='" + websites + '\'' +
                ", facebookLink='" + facebookLink + '\'' +
                ", githubLink='" + githubLink + '\'' +
                ", LinkedInLink='" + LinkedInLink + '\'' +
                ", location='" + location + '\'' +
                ", companySize=" + companySize +
                ", about='" + about + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
