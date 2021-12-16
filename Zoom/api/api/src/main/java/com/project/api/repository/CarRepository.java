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

	// More Filtering Option Here

	public Car findByNumberPlate(String numberPlate);
	
	public List<Car> findByPincodeContainsOrCityContainsAllIgnoreCase(String pincode, String city);
	
}
