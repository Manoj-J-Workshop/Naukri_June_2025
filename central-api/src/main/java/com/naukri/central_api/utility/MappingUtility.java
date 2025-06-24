package com.naukri.central_api.utility;

import com.naukri.central_api.dto.JobSeekerRegistrationDTO;
import com.naukri.central_api.models.AppUser;
import com.naukri.central_api.models.Skills;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MappingUtility {

    public AppUser mapJobSeekerDetailsToAppUser(JobSeekerRegistrationDTO jobSeekerDTO, List<Skills> skills){
        AppUser appUser = new AppUser();
        appUser.setUserType("JOB_SEEKER");
        appUser.setName(jobSeekerDTO.getName());
        appUser.setEmail(jobSeekerDTO.getEmail());
        appUser.setPassword(jobSeekerDTO.getPassword());
        appUser.setPhoneNumber(jobSeekerDTO.getPhoneNumber());
        //Not Able to Set jobSeekerDTO as we are getting List<String> from jobSeekerDTO
        //Need to convert List<String> to List<Skills>
        // Done

        appUser.setSkills(skills);
        //appUser.setCompany(null);

        return appUser;
        
    }
}
