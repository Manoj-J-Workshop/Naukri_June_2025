package com.naukri.database_api.repository;

import com.naukri.database_api.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository <Job, UUID> {
}
