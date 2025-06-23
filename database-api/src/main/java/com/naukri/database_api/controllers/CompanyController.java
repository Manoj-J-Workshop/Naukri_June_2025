package com.naukri.database_api.controllers;

import com.naukri.database_api.models.Company;
import com.naukri.database_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/company")
public class CompanyController {

    CompanyRepository companyRepository;
    @Autowired
    public CompanyController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @PostMapping("/save")
    public ResponseEntity createComapny(@RequestBody Company company){
        companyRepository.save(company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getcompanyById(@PathVariable UUID id){
        Company company = companyRepository.findById(id).orElse(null);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(company, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllCompanies(){
        List<Company> companyList = companyRepository.findAll();
        return new ResponseEntity<>(companyList, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateCompany(@RequestBody Company company){
        companyRepository.save(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCompanyByID(@PathVariable  UUID id){
        companyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
