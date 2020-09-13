package com.springboot.parkinglot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

import lombok.Data;

@Data
@Entity
public class VehicleDTO {
	
	@Id
	private Long id;
	private String vehicleNumber;
	private String ownerName;
}
