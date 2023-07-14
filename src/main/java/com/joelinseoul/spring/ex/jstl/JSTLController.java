package com.joelinseoul.spring.ex.jstl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSTLController {

	@GetMapping("/jstl/ex01")
	public String ex01(){
		return "jstl/ex01";
		
	}
	
	
	@GetMapping("/jstl/ex02")
	public String ex02(Model model) {
		
		List<String> fruitList = new ArrayList<>();
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("바나나");
		fruitList.add("수박");
		
		model.addAttribute("fruitlist", fruitList);
		
		return "jstl/ex02";
	}
	
	
}
