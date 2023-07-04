package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Dto.Content;
import com.masai.Dto.User;

@RestController
public class Contoler {
	
	@Autowired
 private Service s;
	
	@GetMapping(value = "/hello")
 ResponseEntity<String> hello(){
		
		return new  ResponseEntity<String>("hello",HttpStatus.OK);
	}
	
 @PostMapping(value = "/contents")
	 ResponseEntity<String> addContent(@RequestBody Content c){
		
		return s.addContent(c);
	}
 
	@GetMapping(value = "/contents")
 ResponseEntity<List<Content>> browseContent(){
		return s.browseContent();
 }
	
	@PostMapping(value = "/users")
	 ResponseEntity<String> registerUser(@RequestBody User user){
		return s.registerUser(user);
		 
	 }
	
	@PostMapping(value = "/streams/{userId}/{contentId}")
	 ResponseEntity<String>chooseContentToStream(@PathVariable("userId") Integer userId,@PathVariable("contentId") Integer contentId){
		
		return s.chooseContentToStream(userId,contentId);
		
	}
	@GetMapping(value = "/users")
	ResponseEntity<List<User>> browseUser(){
		
		return s.browseUser();
		
	}
	@PostMapping(value = "/users/{userId}")
	List<Content> provideRecommendations(@PathVariable("userId") Integer userId){
		
		return s.provideRecommendations(userId);
	}
}
