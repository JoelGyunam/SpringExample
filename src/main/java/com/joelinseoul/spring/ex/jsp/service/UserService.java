package com.joelinseoul.spring.ex.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelinseoul.spring.ex.jsp.domain.User;
import com.joelinseoul.spring.ex.jsp.repository.UserRepository;

@Service
public class UserService {

	// 사용자 정보를 전달받고 저장하는 기능
	
	@Autowired
	private UserRepository userRepository;
	
	
	public int addUser(String name, String birthday, String email, String introduce) {
		int count = userRepository.insertUser(name,birthday,email,introduce);
		return count;
	}
	
	// 가장 최근데 등록된 사용자 등록 정보 얻기
	
	public User getLastUser() {
		User user = userRepository.selectlastUser();
		return user;
	}
	
}
