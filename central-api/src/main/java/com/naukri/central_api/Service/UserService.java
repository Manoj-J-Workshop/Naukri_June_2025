package com.naukri.central_api.Service;

import com.naukri.central_api.connectors.DatabaseApiConnectors;
import com.naukri.central_api.dto.JobSeekerRegistrationDTO;
import com.naukri.central_api.models.AppUser;
import com.naukri.central_api.models.Skills;
import com.naukri.central_api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    SkillService skillService;
    MappingUtility mappingUtility;
    DatabaseApiConnectors dbApiConnectors;

    @Autowired
    public UserService(SkillService skillService, MappingUtility mappingUtility, DatabaseApiConnectors dbApiConnectors){
        this.skillService = skillService;
        this.mappingUtility = mappingUtility;
        this.dbApiConnectors = dbApiConnectors;
    }

    public AppUser registerJobSeeker(JobSeekerRegistrationDTO jobSeekerDTO){
        //To map data of jobSeekerDto -> AppUser Model
        // Opt1. Write mapping logic here itself. -> code looks bulky and not re-usable.
        // Opt2. Write mapping logic in different class and call the mapping method of that class from here itself.

        List<String> skillNames = jobSeekerDTO.getSkills();
        List<Skills> skills = skillService.getAllSkills(skillNames);
        AppUser jobSeeker = mappingUtility.mapJobSeekerDetailsToAppUser(jobSeekerDTO, skills);
        AppUser user = this.saveUser(jobSeeker);
        return user;
    }

    AppUser saveUser(AppUser user){
        // This method will be having logic to call Save user endpoint of appuser controller of DB api
        return dbApiConnectors.callSaveUserEndpoint(user);
    }
}
