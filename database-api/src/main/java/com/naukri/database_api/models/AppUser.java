package com.naukri.database_api.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUser {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     //@Column(nullable = false, unique = true)
     UUID id;

     //@Column(nullable = false)
     String name;

     @Column(name = "user_email",unique = true, nullable = false)
     String email;

     @Column(nullable = false)
     String password;

     @Column(unique = true, nullable = false)
     Long phoneNumber;

     String userType;

     @ManyToOne
     Company company;

     @ManyToMany
     List<Skills> skills;

     @CreationTimestamp
     LocalDateTime createdAt;
     @UpdateTimestamp
     LocalDateTime updatedAt;
}
