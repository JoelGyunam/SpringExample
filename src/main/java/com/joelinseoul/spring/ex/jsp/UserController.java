package com.joelinseoul.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joelinseoul.spring.ex.jsp.domain.User;
import com.joelinseoul.spring.ex.jsp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	// 이름, 생년월일, 이메일, 자기소개 전달받고, 데이터 저장.
	//@RequestMapping("/jsp/user/add")
	@PostMapping("/jsp/user/add")
	public String createUser(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday
			, @RequestParam("email") String email
			, @RequestParam("introduce") String introduce
			, Model model) {
		
//		int count = userService.addUser(name,birthday,email,introduce);
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		user.setIntroduce(introduce);
		
		int count = userService.addUserByObject(user);
		
		model.addAttribute("user",user);
		
		return "jsp/userInfo";
//		return "입력 성공" + count;
	}
	
	// userinut jsp 페이지 보여주기
	@GetMapping("/input")
	public String userInput() {
		return "jsp/userinput";
	}
	
	@GetMapping("/lastuser")
	public String lastUser(Model model) {
		
		User user = userService.getLastUser();
		
		model.addAttribute("user", user);
		
		return "jsp/userInfo";
	}
	
}
