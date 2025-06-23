package com.naukri.database_api.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String Status;

    @Column(name = "Job Title", nullable = false)
    String shortDescription; // or Small description

    @Column(nullable = false)
    String location;

    @Column(name = "Job Description", nullable = false)
    String fullDescription;

    @CreationTimestamp
    @Column(name = "Posted_On", nullable = false)
    LocalDateTime postedDate;

    @Column(name = "Total_Applicants", nullable = false)
    Long totalApplicants;

//    @OneToMany
//    Company company;

    @ManyToOne
    AppUser createdBy; //This is the recruiter who created the job

    @OneToOne
    Application_Form application_form;

    @OneToMany
    List<FormSubmission> JobApplicantions;

    @ManyToMany
    List<Skills> skills;



    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;
}
