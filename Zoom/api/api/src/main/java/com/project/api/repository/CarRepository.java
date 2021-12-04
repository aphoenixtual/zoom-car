package com.project.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.api.entity.Car;
import com.project.api.entity.LenderDetail;

/**
 * @author: Aayush C Note: Description:Car Repository
 */

@Repository
public interface CarRepository extends CrudRepository <Car,Integer> {

}
