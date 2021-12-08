package com.project.backend.service;

import java.util.Arrays;
import java.util.List;

import com.project.backend.entity.Address;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {
    private RestTemplate template = new RestTemplate();
	
	private String url = "http://localhost:8080/address/address";

    public List<Address> getAll(){
		return Arrays.asList(template.getForObject(url, Address[].class));
	}
	
    public Address getById(int id) {
		String url1=url+"/"+id;
		return template.getForObject(url1,Address.class);
	}



   //Adding Address from port 8085 to 8080
	public Address addNewAddress(Address theAddress)
	{
		return template.postForObject(url,theAddress,Address.class);
	}




	//Deleting Address
	public void deleteAddress(int id)
	{
		String deleteUrl=url+"/"+id;
		template.delete(deleteUrl);

	}



	//Updating Address by id
	public void updateAddressById(Address theAddress)
	{

		template.put(url,theAddress,Address.class);
	}


}
