package com.naukri.central_api.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    UUID id;
    String Company_name;

    String Company_email;

    String Company_website;

    String Company_linkedinLink;

    Long Company_size;

    String industry;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
