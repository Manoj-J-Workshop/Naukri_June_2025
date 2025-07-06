package com.naukri.central_api.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyRegisterDTO {

    String companyName;
    String companyEmail;
    Long phoneNumber;
    String companyWebsite;
    String companyLinkedinLink;
    String password;
    Long companySize;
    String industry;

}
