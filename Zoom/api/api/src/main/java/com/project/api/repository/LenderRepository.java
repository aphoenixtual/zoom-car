package com.project.api.repository;

/**
 * @author: Aayush C Note: Description:Lender Repository
 */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.api.entity.LenderDetail;

@Repository
public interface LenderRepository extends CrudRepository<LenderDetail,Integer>{

}
