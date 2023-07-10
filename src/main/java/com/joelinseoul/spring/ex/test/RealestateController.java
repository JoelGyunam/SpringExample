package com.joelinseoul.spring.ex.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joelinseoul.spring.ex.test.domain.Realestate;
import com.joelinseoul.spring.ex.test.service.RealestateService;



@Controller
public class RealestateController {

	@Autowired
	private RealestateService realestateService;
	
	
	@RequestMapping("/mybatis/test01/realestateInfo")
	@ResponseBody
	public Realestate realestateInfo(@RequestParam("id") int id) {
		Realestate realestateInfo = realestateService.getRealestate(id);
		
		return realestateInfo;
	}
	
}
