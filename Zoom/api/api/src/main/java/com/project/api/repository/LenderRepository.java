package com.project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.api.entity.Lender;

@Repository
public interface LenderRepository extends JpaRepository<Lender, Integer>{

}
