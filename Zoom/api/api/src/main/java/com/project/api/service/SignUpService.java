package com.project.api.service;

import com.project.api.entity.signup;
import com.project.api.repository.SignUpRepository;
import com.thoughtworks.xstream.mapper.Mapper;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.api.entity.User;

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
            return "1";
        }
        return "0";

    }

    public String checkLogin(String name,String password)
    {
        signup signUp=signUpRepository.findByNameAndPassword(name, password);
        if(Objects.isNull(signUp))
        {
            return "0";
        }
        return "1";

    }
}
