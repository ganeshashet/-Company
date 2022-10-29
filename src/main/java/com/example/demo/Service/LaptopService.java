package com.example.demo.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.Model.Laptop;
import com.example.demo.Repository.LaptopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {
	@Autowired
	private LaptopRepository repo;
	// Adding lap-top to database 
	public String Addlatop(Laptop l1) {
		String msg=null;
		Laptop _l2=repo.save(l1);
		if(_l2!=null)
		{
	    return "Laptops details sucessfully added..."+new Date();
		}
		else
		{
		msg=null;
		}
		return msg;
	}
	// Retrieving or displaying Lap-tops form database
	public List<Laptop> getLatop()
	{
		return repo.findAll();
	}
	//Updating the existing in Lap-top 
	public String UpdateLaptop(Laptop l1)
	{
		Laptop _l2=repo.save(l1);
		if(_l2!=null)
		{
			return "Laptop is Updated...."+new Date();
		}
		else
		{
			return null;
		}
	}
	//Deleting Lap-top  by its Id
		public String DeletingLaptop(int laptopId)
		{
			//Optional<Laptop> _l1=repo.findById(laptopId);
			Optional<Laptop> status=repo.findById(laptopId);
			if(status!=null)
			{
				repo.deleteById(laptopId);
				return "Laptop is Deleted...."+new Date();
			}
			else
			{
				return null;
			}
		}
		
		//sorting the list of Lap-tops based on a specific field of a table
		public List<Laptop> getLaptops(String field)
		{
			return repo.findAll(Sort.by(Direction.DESC,field));
		}
		
	

}
