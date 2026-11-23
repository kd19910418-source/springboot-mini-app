package com.example.demo.dto;

public class MiniUserDto {

	private Integer id;
	private String name;
	private Integer age;
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
