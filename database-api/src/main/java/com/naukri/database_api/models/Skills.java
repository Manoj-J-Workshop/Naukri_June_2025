package com.naukri.database_api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID skill_Id;

    String skill_name;

}
