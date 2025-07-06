package com.naukri.central_api.Service;

import com.naukri.central_api.connectors.DatabaseApiConnectors;
import com.naukri.central_api.dto.CompanyRegisterDTO;
import com.naukri.central_api.models.AppUser;
import com.naukri.central_api.models.Company;
import com.naukri.central_api.utility.MappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    MappingUtility mappingUtility;
    DatabaseApiConnectors databaseApiConnectors;
    UserService userService;

    @Autowired
    public CompanyService(MappingUtility mappingUtility, DatabaseApiConnectors databaseApiConnectors, UserService userService){
        this.mappingUtility = mappingUtility;
        this.databaseApiConnectors = databaseApiConnectors;
        this.userService = userService;
    }
    /**
     * The Expectation of this function is to save company details in the company table
     * To Save company details it will be calling DB API connector
     * Which will hit request to DB API company controller save endpoint
     * @return Company
     */

    public Company registerCompany(CompanyRegisterDTO companyRegisterDTO){
        //Map companyRegisterDTO details to Company class
        Company company = mappingUtility.mapCompanyDtoToCompanyModel(companyRegisterDTO);
        // Now we need to save this company model inside our DB
        company = this.saveCompany(company);
        // Now we should create admin account for the company
        AppUser admin = mappingUtility.mapCompanyDtoToAdmin(companyRegisterDTO,company);
        // Now we need to save admin user in DB
        userService.saveUser(admin);
        //returning a Company object
        return company;
    }

    /**
     * This save method will internally call DB api connector --> calling DB api to save company details
     * @return Company
     */
    public Company saveCompany(Company company){
        // database api connector to save company details in the companu table.
        return databaseApiConnectors.callSaveCompanyEndpoint(company);
    }
}
