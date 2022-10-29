package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Model.Laptop;
import com.example.demo.Service.LaptopService;

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
public class LaptopContoller {
	@Autowired
	private LaptopService service;
	// adding the Laptops to laptops table
	@PostMapping("/AddLaptop")
	public ResponseEntity<String>  AddLaptop(@RequestBody Laptop l1)
	{
		String status=service.Addlatop(l1);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	// displaying the  Laptops in table
	@GetMapping("/getLaptop")
	public ResponseEntity<List<Laptop>> getLaptop()
	{
		return new ResponseEntity<>(service.getLatop(),HttpStatus.OK);
	}
	// Updating the laptop details 
	@PutMapping("/UpdateLaptop")
	public ResponseEntity<String> Updatelaptop(@RequestBody Laptop l1)
	{
		String status=service.UpdateLaptop(l1);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.OK);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Deleting the laptop using laptop id
	@DeleteMapping("/deleteLaptop/{laptopId}")
	public ResponseEntity<String> DeleteLaptop(@PathVariable int laptopId)
	{
		String status=service.DeletingLaptop(laptopId);
		if(status!=null)
			return new ResponseEntity<>(status,HttpStatus.OK);
		else
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//getting sorted list of Lap-tops based on specific field of table 
	@GetMapping("/getLaptops/{field}")
	public ResponseEntity<List<Laptop>> getLaptops(@PathVariable String field)
	{
		return new ResponseEntity<>(service.getLaptops(field),HttpStatus.OK);
	}

}
