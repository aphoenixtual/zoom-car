package com.project.api.controller;


import com.project.api.entity.signup;
import com.project.api.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<signup> addNew(@RequestBody signup theSignUp)
    {
        System.out.println(theSignUp);
        if(signUpService.check(theSignUp.getEmail())=="1")
        {
            System.out.println(theSignUp);

            return ResponseEntity.of(Optional.of(signUpService.addNew(theSignUp)));

        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> checkLogin(@RequestBody signup theSignUp)
    {
        System.out.println("------->>"+theSignUp);
        if(signUpService.checkLogin(theSignUp.getEmail(),theSignUp.getPassword())=="0") {
            System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        System.out.println(" JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
        return ResponseEntity.of(Optional.of("1"));

    }

}
