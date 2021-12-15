package com.project.api.repository;

import com.project.api.entity.signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignUpRepository extends JpaRepository<signup, Integer> {
    public signup findByEmail(String email);
    public signup findByEmailAndPassword(String name,String password);

}
