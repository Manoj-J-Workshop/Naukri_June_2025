package com.naukri.central_api.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Skills {
    UUID skill_Id;
    String skill_name;

}
