package com.dzee.gslab.dao;

import com.dzee.gslab.model.Address;
import com.dzee.gslab.model.User;

public class UserDao {

	public User getUserDetails(String username) {
		Address address = new Address();
		address.setCity("Delhi");
		address.setCountry("India");
		address.setPin("410023");
		address.setStreet("MG Road");

		User user = new User();
		user.setAddress(address);
		user.setDesignation("Manager");
		user.setEmail("abc@gmail.com");
		user.setFirstname("Bob");
		user.setLastname("Roy");
		user.setPhone("0000111123");

		return user;
	}
}
