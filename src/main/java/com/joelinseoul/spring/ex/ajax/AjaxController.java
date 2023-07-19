package com.joelinseoul.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@GetMapping("/ajax/test")
	public String ajaxTest(){
		return "ajax/ajax";
	}
	
	// 한 사람의 정보를 json으로 reponse에 담기
	@GetMapping("/ajax/person")
	@ResponseBody
	public Map<String,String> personInfo(){
		Map<String,String> personMap = new HashMap<>();
		personMap.put("name", "김인규");
		personMap.put("age", "29");
		
		return personMap;
	}
	

	
}
