package com.project.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.api.entity.Car;

/**
 * 
 * @author Aayush.C
 *
 */

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	public List<Car> findByCity(String city);

	public List<Car> findByPincode(int pincode);



	/**************************************************/

	public List<Car> findByCompany(String company);

	public List<Car> findByNumberOfSeat(int seat);
	
	/**************************************************/

	public List<Car> findByPincodeAndNumberOfSeat(int pincode,int numberOfSeats);

	public List<Car> findByPincodeAndNumberOfSeatAndCompany(int pincode,int numberOfSeats,String company);
	// More Filtering Option Here
}
