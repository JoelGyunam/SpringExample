package com.joelinseoul.spring.ex.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelinseoul.spring.ex.ajax.repository.NewUserRepository;
import com.joelinseoul.spring.ex.jsp.domain.User;

@Service
public class NewUserService {

	@Autowired
	private NewUserRepository newUserRepository;
	
	public List<User> getUserList(){
		List<User> userList = newUserRepository.selectUserList();
		return userList;
	}
	
	
	public int addUser(
					String name
					,String birthday
					,String email
					,String introduce
					) {
		int count = newUserRepository.insertUser(name, birthday, email, introduce);
		return count;
	}
	
	//전달된 이메일이 이미 있는 지 확인하는 method
	public boolean isDuplicatedEmail(String email) {
		
		int count = newUserRepository.selectCountEmail(email);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
