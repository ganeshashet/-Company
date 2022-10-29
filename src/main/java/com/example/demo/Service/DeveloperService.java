package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Developer;
import com.example.demo.Repository.DeveloperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {
	
	@Autowired
	private DeveloperRepository devrespo;
	 // Adding details of developer and  displaying with time and Date 
	public String AddDevloper(Developer d1)
	{
		String msg=null;
		Developer _d2=devrespo.save(d1);
		if(_d2!=null)
		{
			return "Developer Details are added....."+new Date();
		}
		else
		{
			msg=null;
		}
		return msg;
	}
	//fetching the details form table
	public List<Developer> addAllDevelopers()
	{
		return devrespo.findAll();
	}
	//Updating the table
	public String UpdateDevloper(Developer d1)
	{
		Developer _d2=devrespo.save(d1);
		if(_d2!=null)
		{
			return "Developer Table is Updated...."+new Date();
		}
		else
		{
			return null;
		}
	}
	// deleting the developer details with id
	public String DeleteDeveloper(int developerId)
	{
		Optional<Developer> _l1=devrespo.findById(developerId);
		if(_l1!=null)
		{
			devrespo.deleteById(developerId);
			return "Deleted Successfully ......."; 
		}
		else
		{
			return null;
		}
		
	}

}
