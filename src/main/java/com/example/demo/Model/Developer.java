package com.example.demo.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Developer {
	@Id
	private int developerId;
	private String developerName;
	private String developerRole;
	private String developerDesign;
	@OneToMany
	@JoinColumn(name="devloperId")
	private List<Laptop> developerLaptop;

}
