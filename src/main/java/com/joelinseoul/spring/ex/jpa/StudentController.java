package com.joelinseoul.spring.ex.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joelinseoul.spring.ex.jpa.domain.Student;

@Controller
public class StudentController {

	@GetMapping("/jpa/test")
	@ResponseBody
	public String student() {
		
		Student student = new Student();
		String name = student.getName();
		
		return name;
		
	};
	
}
