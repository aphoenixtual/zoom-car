package com.project.api.controller;


import com.project.api.entity.signup;
import com.project.api.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    SignUpService signUpService;
    @CrossOrigin
    @PostMapping("/signup")
    public String addNew(@RequestBody signup theSignUp)
    {
        System.out.println(theSignUp);
        if(signUpService.check(theSignUp.getEmail())=="1")
        {
            System.out.println(theSignUp);
            signUpService.addNew(theSignUp);
            return "1";

        }
        return "0";

    }
    @CrossOrigin
    @PostMapping("/login")
    public String checkLogin(@RequestBody signup theSignUp)
    {
        System.out.println(theSignUp);
        if(signUpService.checkLogin(theSignUp.getName(),theSignUp.getPassword())=="0") {
            return "0";
        }
        return "1";

    }

}
