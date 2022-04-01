package com.edusol.communication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.communication.model.User;
import com.edusol.communication.service.CommunicationService;

@RestController
@RequestMapping("/communication")
public class CommunicationController {
	@Autowired
	private CommunicationService communicationservice;

	@GetMapping("/get-users")
	public List<User> getuser() {
		return communicationservice.getUsers();
	}

	
	@GetMapping("/get-users-byname}")
     public List<User> getuserbyName(@RequestParam String name) {
		return communicationservice.getUsersByName(name);
	}

	@GetMapping("/get-users-byemail}")
	public List<User> getuserbyEmail(@RequestParam String email) {
		return communicationservice.getUsersByEmail(email);
	}

	
	@GetMapping("/get-users-bycity")
	public List<User> getuserbyCity(@RequestParam String city) {
		return communicationservice.getUsersByCity(city);
	}

	@PutMapping("/update-user")
	public String updateUser(@RequestBody User user) {
		return communicationservice.updateUser(user);
	}

	@DeleteMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable int id) {
		return communicationservice.deleteUser(id);
	}

	/*
	 * @PostMapping("/adduser") public List<User> addUsers(@RequestBody User user) {
	 * return communicationservice.addUsers(user); }
	 */
}
