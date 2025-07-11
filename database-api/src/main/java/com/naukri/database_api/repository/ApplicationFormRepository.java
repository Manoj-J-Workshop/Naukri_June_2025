package com.naukri.database_api.repository;

import com.naukri.database_api.models.Application_Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationFormRepository extends JpaRepository <Application_Form, UUID>{
}
