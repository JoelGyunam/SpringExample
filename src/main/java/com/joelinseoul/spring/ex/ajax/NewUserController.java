package com.joelinseoul.spring.ex.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joelinseoul.spring.ex.ajax.service.NewUserService;
import com.joelinseoul.spring.ex.jsp.domain.User;
@RequestMapping("/ajax/user")
@Controller
public class NewUserController {

	@Autowired
	private NewUserService newUserService;
	
	@GetMapping("/list")
	public String userList(Model model) {
		
		List<User> userList = newUserService.getUserList();
		
		model.addAttribute("userList",userList);
		
		return "ajax/user/list";
	}
	
	@GetMapping("/add")
	@ResponseBody
	public Map<String, String> createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday")String birthday
			,@RequestParam("email")String email
			,@RequestParam("introduce")String introduce
			) {
		int count = newUserService.addUser(name, birthday, email, introduce);
		
		// 성공 실패 여부
		//{"result":"success"}
		//{"result":"fail"}
		
		Map<String,String> resultMap = new HashMap<>();
		if(count ==1) {
			resultMap.put("result", "success");
		} else resultMap.put("result", "fail");
		
		return resultMap;
	}
	
	@GetMapping("/input")
	public String userInput() {
		return "ajax/user/input";
	}
	
	//email을 전달받고, 이미 가입된 이메일인지를 알려주는 api
	@GetMapping("/email_confirm")
	@ResponseBody
	public Map<String, Boolean> isDuplicatedEmail(@RequestParam("email")String email) {
		Map<String, Boolean> resultMap = new HashMap<>();
		// 중복됨 : {"isDuplicated":true}
		// 중복 안됨 : {"isDuplicated":false}
		if(newUserService.isDuplicatedEmail(email)) {
			resultMap.put("isDuplicated", true);
		} else {
			resultMap.put("isDuplicated", false);
		}
		
		return resultMap;
	}
	
}
