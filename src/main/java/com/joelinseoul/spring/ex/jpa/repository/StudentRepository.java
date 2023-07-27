package com.joelinseoul.spring.ex.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.joelinseoul.spring.ex.jpa.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public List<Student> findAllByOrderByIdDesc();
	
	public List<Student> findTop1ByOrderByIdDesc();
	
	public List<Student> findByName(String name);
	
	public List<Student> findByNameIn(List<String> nameList);
	
	//`email` LIKE '%naver%'
	public List<Student> findByEmailContaining(String email);
	
	//`name` LIKE '김%'
	public List<Student> findByNameStartingWith(String name);
	
	//BETWEEN
	//orderBy id
	public List<Student> findByIdBetweenOrderByIdDesc(int start, int end);
	
	//native query
	@Query(value="SELECT * FROM `new_student` WHERE `dreamJob` = :dreamJob", nativeQuery=true)
	public List<Student> findByDreamJobNative(@Param("dreamJob")String dreamJob);
	
}
