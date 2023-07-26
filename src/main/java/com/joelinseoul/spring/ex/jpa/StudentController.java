package com.joelinseoul.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joelinseoul.spring.ex.jpa.domain.Student;
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
}
