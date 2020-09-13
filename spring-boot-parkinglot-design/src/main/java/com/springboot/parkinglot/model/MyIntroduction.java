package com.springboot.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class MyIntroduction {
	
	private String name;
	private int age;
	private String skills;
}
