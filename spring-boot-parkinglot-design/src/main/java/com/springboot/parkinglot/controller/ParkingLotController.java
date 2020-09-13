package com.springboot.parkinglot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.parkinglot.model.MyIntroduction;
import com.springboot.parkinglot.model.VehicleDTO;
import com.springboot.parkinglot.service.ParkingService;

@RestController
@RequestMapping("/parkinglot")
@CrossOrigin(origins = "*") 
public class ParkingLotController {
	
	@Autowired
	ParkingService parkingService;

	@GetMapping("/aboutMe")
	public MyIntroduction myIntro() {
		return MyIntroduction.builder().name("samarth").age(25).skills("Java, Spring boot").build();
	}
	
	@PostMapping("/infoAboutSomeOne")
	public MyIntroduction aboutSomeOne(String name, int age, String skills){
		return MyIntroduction.builder().name(name).age(age).skills(skills).build();
		
	}

	@GetMapping("/parkingInfo")
	public List<VehicleDTO> getAllVehicles() {
		return parkingService.getAllVehicles();
	}

	@PostMapping("/park")
	public String park(VehicleDTO vehicleDTO) {
		return parkingService.park(vehicleDTO);
	}

	@DeleteMapping("/unpark")
	public String unpark(Long id) {
		return parkingService.unpark(id);
	}
}
