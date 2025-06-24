package com.naukri.central_api.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JobSeekerRegistrationDTO {

    private String name;
    private String email;
    private String password;
    private Long phoneNumber;
    private List<String> skills;
}
