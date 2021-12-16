package com.project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.api.entity.CarBooked;

@Repository
public interface BookingRepository extends JpaRepository<CarBooked, Integer>{

}
