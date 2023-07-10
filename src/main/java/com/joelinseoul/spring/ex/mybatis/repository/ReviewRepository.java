package com.joelinseoul.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.joelinseoul.spring.ex.mybatis.domain.Review;

@Repository
public interface ReviewRepository {

	// id가 3인 리뷰데이터 조회
	
	public Review selectReview(@Param("id") int id);
	
	
	// 데이터를 전달받고 insert
	
	public int insertReview(
			@Param("storeId") int storeId
			,@Param("menu") String menu
			,@Param("userName") String userName
			,@Param("point") double point
			,@Param("review") String review);
	
	// 객체로 데이터 전달받고 insert
	
	public int insertReviewByObject(Review review);
	
	
}
