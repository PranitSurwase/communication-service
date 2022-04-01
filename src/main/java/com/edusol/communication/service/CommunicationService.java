package com.edusol.communication.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edusol.communication.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CommunicationService {

	@Autowired
	private RestTemplate template;
	
	@HystrixCommand(fallbackMethod = "showfallback")
	public List<User> getUsers() {
		 final String url = "http://localhost:8084/user";
		//final String url = "http://user-service/user";
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);
		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		List<User> user = Arrays.asList(response.getBody());
		return user;
	}

	@HystrixCommand(fallbackMethod = "showfallback")
	public List<User> getUsersByName(String name) {
		final String url = "http://localhost:8084/user/name?name=" + name;
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);
		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		List<User> user = Arrays.asList(response.getBody());
		return user;
	}

	@HystrixCommand(fallbackMethod = "showfallback")
	public List<User> getUsersByEmail(String email) {

		final String url = "http://localhost:8084/user/email?email=" + email;
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);
		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		List<User> user = Arrays.asList(response.getBody());
		return user;
	}

	@HystrixCommand(fallbackMethod = "showfallback")
	public List<User> getUsersByCity(String city) {
		final String url = "http://localhost:8084/user/city?city=" + city;
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(header);
		ResponseEntity<User[]> response = template.exchange(url, HttpMethod.GET, entity, User[].class);

		List<User> user = Arrays.asList(response.getBody());
		return user;
	}

	@HystrixCommand(fallbackMethod = "showfallback")
	public String updateUser(User user) {
		final String url = "http://localhost:8084/user";
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<User> entity = new HttpEntity<User>(user, header);
		String response = template.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
		return response;

	}
	

	
	public String showfallback(User user) {
		return "Request failed ,it takes too long to response";
	}
	
	

	@HystrixCommand(fallbackMethod = "showfallback")
	public String deleteUser(int id) {
		final String url = "http://localhost:8084/user/" + id;
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<User>(header);
		String response = template.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
		return response;

	}

	/*
	 * public List<User> addUsers(User user) { final String
	 * url="http://localhost:8084/user"; HttpHeaders header = new HttpHeaders();
	 * header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	 * 
	 * HttpEntity<String> entity= new HttpEntity<String>(header);
	 * ResponseEntity<User[]> response= template.exchange(url, HttpMethod.POST,
	 * entity, User[].class);
	 * 
	 * List<User> user1 = Arrays.asList(response.getBody()); return user1; }
	 */

	/*
	 * public List<User> addUsers() { final String url="http://localhost:8084/user";
	 * HttpHeaders header = new HttpHeaders();
	 * header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); HttpEntity<User>
	 * entity= new HttpEntity<User>(header); ResponseEntity<User[]> response=
	 * template.exchange(url, HttpMethod.POST, entity, User[].class);
	 * 
	 * List<User> user = Arrays.asList(response.getBody()); return user;
	 * 
	 * }
	 */
}
