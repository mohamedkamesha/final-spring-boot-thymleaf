package com.example.aabbcc.DTO;

import com.example.aabbcc.model.Applicant;
import com.example.aabbcc.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountApplicant {

    private User user;
    private Applicant applicant;

}
