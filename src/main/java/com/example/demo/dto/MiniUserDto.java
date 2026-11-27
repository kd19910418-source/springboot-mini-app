package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MiniUserDto {

	private Integer id;
	@NotBlank
	private String name;
	@NotNull
	@Min(0)
	@Max(120)
	private Integer age;
	@NotBlank
	@Email
	private String email;

	//constructor
	public MiniUserDto() {
	}

	public MiniUserDto(
			Integer id,
			String name,
			Integer age,
			String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}

	//getter 
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}
}
