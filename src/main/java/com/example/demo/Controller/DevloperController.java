package com.example.demo.Controller;


import java.util.List;

import com.example.demo.Model.Developer;
import com.example.demo.Service.DeveloperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevloperController {
	@Autowired
	private DeveloperService service;
	// Adding the developer details to databse
	@PostMapping("/addDeveloper")
	public ResponseEntity<String> AddDeveloper(@RequestBody Developer d1)
	{
		String status=service.AddDevloper(d1);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// Displaying the developers details
	@GetMapping("/getDevelopers")
	public ResponseEntity<List<Developer>> addDevelopers()
	{
		 return new ResponseEntity<>(service.addAllDevelopers(),HttpStatus.OK);
	
	}
	// Updating the Developers table
	@PutMapping("/updateDeveloper")
	public ResponseEntity<String> UpdateDeveloper(@RequestBody Developer d1)
	{
		String status=service.UpdateDevloper(d1);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.OK);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// Deleting the developer details form developer table
	@DeleteMapping("/deleteDeveloper/{developerId}")
	public ResponseEntity<String> DeleteDeveloper(@PathVariable int developerId)
	{
		String status=service.DeleteDeveloper(developerId);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.OK);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

}
