package com.springboot.parkinglot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.parkinglot.model.VehicleDTO;
import com.springboot.parkinglot.repository.ParkingRepository;
import com.springboot.parkinglot.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired
	ParkingRepository parkingRepository;
	
	@Override
	public List<VehicleDTO> getAllVehicles() {
		return parkingRepository.findAll();
	}

	@Override
	public String park(VehicleDTO vehicleDTO) {
		if(vehicleDTO.getId() >0 && vehicleDTO.getId() <=10) {
			List<VehicleDTO> dtos = parkingRepository.findAll();
			for(VehicleDTO dto : dtos) {
				if(dto.getId() != vehicleDTO.getId()) {
					parkingRepository.save(vehicleDTO);
				}
				else {
					throw new RuntimeException(vehicleDTO.getId()+ " slot is not vacant");
				}
			}
			
		}
		else {
			throw new RuntimeException("Kindly provide a id between 1 to 10");
		}
		return "Parked";
	}

	@Override
	public String unpark(Long id) {
		if(id >0 && id <=10) {
			parkingRepository.deleteById(id);
		}
		else {
			throw new RuntimeException("Kindly provide a id between 1 to 10");
		}
		return "Unparked vehicle at slot number"+ id;
	}

}
