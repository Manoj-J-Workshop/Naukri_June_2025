package com.naukri.database_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID question_Id;
    String question;
}
