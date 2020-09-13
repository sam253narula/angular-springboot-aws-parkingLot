package com.springboot.parkinglot.service;

import java.util.List;

import com.springboot.parkinglot.model.VehicleDTO;

public interface ParkingService {
	
	List<VehicleDTO> getAllVehicles();
	String park(VehicleDTO vehicleDTO);
	String unpark(Long id);
}
