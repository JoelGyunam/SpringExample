package com.joelinseoul.spring.ex.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelinseoul.spring.ex.test.domain.Realestate;
import com.joelinseoul.spring.ex.test.repository.RealestateRepository;



@Service
public class RealestateService {

	@Autowired
	private RealestateRepository realestateRepository;
	
	public Realestate getRealestate(int id) {
		Realestate realestate = realestateRepository.selectRealestate(id);
		return realestate;
	}
	
}
