package com.joelinseoul.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelinseoul.spring.ex.mybatis.domain.Review;
import com.joelinseoul.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	// id가 3인 데이터 얻기
	public Review getReview(int id){
		
		Review review = reviewRepository.selectReview(id);
		
		return review;
		
	}
}
