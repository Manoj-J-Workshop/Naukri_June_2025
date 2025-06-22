package com.naukri.database_api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Application_Form {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    UUID Application_id;

    @OneToOne
    Job job;

    @ManyToMany
    List<Questions> questionsList;
}
