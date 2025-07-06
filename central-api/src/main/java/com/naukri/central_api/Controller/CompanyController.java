package com.naukri.central_api.Controller;

import com.naukri.central_api.Service.CompanyService;
import com.naukri.central_api.dto.CompanyRegisterDTO;
import com.naukri.central_api.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/company")
public class CompanyController {

    CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping("/register")
    public ResponseEntity<Company> registerCompany(@RequestBody CompanyRegisterDTO companyRegisterDTO){

        //Company Service -> to save company details to DB
        Company company = companyService.registerCompany(companyRegisterDTO);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

}
