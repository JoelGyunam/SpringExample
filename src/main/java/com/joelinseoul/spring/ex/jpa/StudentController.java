package com.joelinseoul.spring.ex.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joelinseoul.spring.ex.jpa.domain.Student;
import com.joelinseoul.spring.ex.jpa.repository.StudentRepository;
import com.joelinseoul.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {

//	@GetMapping("/lombok/test")
//	@ResponseBody
//	public void test() {
		
//		Student student = new Student();
//		student.setName("김인규");
//		student.setDream("개발자");
		
//		Student student = Student.builder()
//				.name("김인규")
//				.dreamJob("개발자")
//				.phoneNumber("010-1234-5678")
//				.build();
//		
//		System.out.println(student);
//	};
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		
		String name = "김인규";
		String phoneNumber = "010-1234-5678";
		String email = "lecture@hagulu.com";
		String dreamJob = "개발자";
		
		Student student = studentService.addStudent(name, phoneNumber, email, dreamJob);
		
		return student;
		
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent(){
		// id가 3인 데이터의 장래희망을 강사로 변경.
		Student student = studentService.updateStudentDreamJob(3, "강사");
		return student;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		
		// id가 3인 행 삭제
		studentService.deleteStudent(3);
		return "삭제 성공";
	};
	
	@GetMapping("/select")
	@ResponseBody
	public List<Student> selectStudent() {
//		모든 행 조회
//		List<Student> studentList = studentRepository.findAll();
//		return studentList;
		
//		id기준 전체 내림차준 정렬.
//		List<Student> orderById = studentRepository.findAllByOrderByIdDesc();
//		return orderById;
		
//		OrderBy		
//		List<Student> findTop1 = studentRepository.findTop1ByOrderByIdDesc();
//		return findTop1;
		
//		name 칼럼 기준 조회
//		List<Student> findByName = studentRepository.findByName("유재석");
//		return findByName;
		
//		List<String> nameList = new ArrayList<>();
//		nameList.add("유재석");
//		nameList.add("조세호");
//		List<Student> find = studentRepository.findByNameIn(nameList);
//		return find;
		
//		List<Student> findContainsEmail = studentRepository.findByEmailContaining("naver");
//		return findContainsEmail;
		
//		List<Student> findContainsName = studentRepository.findByNameStartingWith("조");
//		return findContainsName;

//		id 1~3 사이
		List<Student> findByIdBetween = studentRepository.findByIdBetweenOrderByIdDesc(1, 4);
		return findByIdBetween;
		
	};
	
	@GetMapping("/native")
	@ResponseBody
	public List<Student> nativeStudent(){
		List<Student> findByJobNative = studentRepository.findByDreamJobNative("모델");
		return findByJobNative;
	};
}
