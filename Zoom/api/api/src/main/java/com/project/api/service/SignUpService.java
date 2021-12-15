package com.project.api.service;

import com.project.api.entity.signup;
import com.project.api.repository.SignUpRepository;
import com.thoughtworks.xstream.mapper.Mapper;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.api.entity.User;

import javax.persistence.NonUniqueResultException;
import java.util.List;
import java.util.Objects;

@Service
public class SignUpService {
    @Autowired
    SignUpRepository signUpRepository;

    public signup addNew(signup theSign) {
        return signUpRepository.save(theSign);
    }
    public String check(String email)
    {
        signup signUp= signUpRepository.findByEmail(email);
        if(Objects.isNull(signUp))
        {
            System.out.println("Inside");
            return "1";
        }
        System.out.println("OOOOOOOOOOOOOOOOOUtside");
        return "0";

    }

    public String checkLogin(String email,String password)throws NonUniqueResultException
    {
        signup signUp=signUpRepository.findByEmailAndPassword(email, password);
        if(Objects.isNull(signUp))
        {
            System.out.println("ghjfhgdhfjhjfhjfghjfjgh");
            return "0";
        }
        System.out.println("Outside");
        return "1";

    }
}
