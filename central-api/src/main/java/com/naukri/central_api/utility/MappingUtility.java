package com.naukri.central_api.utility;

import com.naukri.central_api.dto.CompanyRegisterDTO;
import com.naukri.central_api.dto.JobSeekerRegistrationDTO;
import com.naukri.central_api.models.AppUser;
import com.naukri.central_api.models.Company;
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

    public Company mapCompanyDtoToCompanyModel(CompanyRegisterDTO companyRegisterDTO){
        Company company = new Company();
        company.setCompany_name(companyRegisterDTO.getCompanyName());
        company.setCompany_email(companyRegisterDTO.getCompanyEmail());
        company.setCompany_website(companyRegisterDTO.getCompanyWebsite());
        company.setCompany_linkedinLink(companyRegisterDTO.getCompanyLinkedinLink());

        company.setCompany_size(companyRegisterDTO.getCompanySize());
        company.setIndustry(companyRegisterDTO.getIndustry());

        return company;
    }

    public AppUser mapCompanyDtoToAdmin(CompanyRegisterDTO companyRegisterDTO, Company company){
        AppUser admin = new AppUser();
        admin.setCompany(company);
        admin.setName("Admin");
        admin.setPassword(companyRegisterDTO.getPassword());
        admin.setEmail(companyRegisterDTO.getCompanyEmail());
        admin.setPhoneNumber(companyRegisterDTO.getPhoneNumber());
        admin.setUserType("ADMIN");
        return admin;
    }
}
