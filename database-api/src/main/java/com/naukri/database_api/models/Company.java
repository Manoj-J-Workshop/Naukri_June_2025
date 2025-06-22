package com.naukri.database_api.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Column(nullable = false)
    String Company_name;

    @Column(unique = true, nullable = false)
    String Company_email;

    @Column(unique = true,nullable = false)
    String Company_website;

    @Column(unique = true,nullable = false)
    String Company_linkedinLink;

    @Column(nullable = false)
    Long Company_size;

    @Column(nullable = false)
    String industry;

    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
}
