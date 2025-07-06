package com.naukri.central_api.connectors;

import com.naukri.central_api.models.AppUser;
import com.naukri.central_api.models.Company;
import com.naukri.central_api.models.Skills;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class DatabaseApiConnectors {

    // We will write all calling methods here only. We will be calling all DB end-points from here.
    @Value("${database.api.baseurl}")
    String baseUrl;

    public Skills callGetSkillsByNameEndpoint(String skillName){
        // in this function we will have logic to hit getSkillByName endpoint of DB API
        //Steps to call API endpoints from Database-API
        // 1. Create URL
        String url = baseUrl + "/skills/get/" +  skillName;
        // 2. Creation of Request
        RequestEntity request = RequestEntity.get(url).build();
        // 3. Use RESTTEMPLATE class to hit the api url
        RestTemplate restTemplate = new RestTemplate();
//        //     exchange - hit/send button // create template -> send -> (url, method, type, response body getting mapped to class)
        ResponseEntity<Skills> response = restTemplate.exchange(url, HttpMethod.GET, request, Skills.class);
        return response.getBody();
//        try {
//            ResponseEntity<Skills> response = restTemplate.exchange(url, HttpMethod.GET, request, Skills.class);
//            return response.getBody();
//        } catch (HttpClientErrorException.NotFound e) {
//            // Return null when skill is not found, so SkillService can handle creation
//            return null;
//        }


    }

    public AppUser callSaveUserEndpoint(AppUser user){
        String url = baseUrl + "/user/save";
        RequestEntity<AppUser> request = RequestEntity.post(url).body(user);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AppUser> response = restTemplate.exchange(url,HttpMethod.POST,request,AppUser.class);
        return response.getBody();
    }

    public Skills callSaveSkillEndpoint(Skills skill){
        String url = baseUrl + "/skills/add";
        RequestEntity<Skills> request = RequestEntity.post(url).body(skill);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Skills> response = restTemplate.exchange(url,HttpMethod.POST,request,Skills.class);
        return response.getBody();
    }

    public Company callSaveCompanyEndpoint(Company company){
        String url = baseUrl + "/company/save";
        RequestEntity<Company> request = RequestEntity.post(url).body(company);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Company> response = restTemplate.exchange(url,HttpMethod.POST,request,Company.class);
        return response.getBody();
    }
}
