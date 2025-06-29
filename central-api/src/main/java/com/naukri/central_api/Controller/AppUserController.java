package com.naukri.central_api.Controller;

import com.naukri.central_api.Service.UserService;
import com.naukri.central_api.dto.JobSeekerRegistrationDTO;
import com.naukri.central_api.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/user")
public class AppUserController {

    UserService userService;

    @Autowired
    public AppUserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> registerJobApplicant(@RequestBody JobSeekerRegistrationDTO jobSeekerDTO) {
        AppUser user = userService.registerJobSeeker(jobSeekerDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
