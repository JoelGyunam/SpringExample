package com.joelinseoul.spring.ex.jpa.domain;

import java.util.Date;

import lombok.Getter;

@Getter
public class Student {
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String dream;
	private Date createdAt;
	private Date updatedAt;
	
}
