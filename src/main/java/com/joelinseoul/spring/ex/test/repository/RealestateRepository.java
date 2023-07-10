package com.joelinseoul.spring.ex.test.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.joelinseoul.spring.ex.test.domain.Realestate;



@Repository
public interface RealestateRepository {

	public Realestate selectRealestate (@Param("id") int id);
}
