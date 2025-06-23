package com.naukri.database_api.repository;

import com.naukri.database_api.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, UUID> {
    public Skills findByName(String name);
}
