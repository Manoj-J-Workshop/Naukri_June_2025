package com.naukri.database_api.controllers;

import com.naukri.database_api.models.AppUser;
import com.naukri.database_api.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class AppUserController {

    AppUserRepository appUserRepository;

    @Autowired
    public AppUserController(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @PostMapping("/save")
    public ResponseEntity createUser(@RequestBody AppUser User){
        appUserRepository.save(User); // Id property will not be set --> shall create new record inside user tbl
        return new ResponseEntity<>(User, HttpStatus.CREATED);
    }

    @GetMapping("/getuserbyId/{id}")
    public ResponseEntity getuserById(@PathVariable UUID id){
        AppUser user = appUserRepository.findById(id).orElse(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody AppUser user){
        // Id property will be set --> shall update existing record inside user tbl
        // If Record is not found will create a new record
        appUserRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable UUID id){
        appUserRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
