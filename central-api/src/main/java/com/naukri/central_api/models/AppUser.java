package com.naukri.central_api.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUser {

    UUID id;
    String name;
    String email;
    String password;
    Long phoneNumber;
    String userType;
    Company company;
    List<Skills> skills;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
