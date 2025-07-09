package com.Studenspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Studenspring.entity.Student;
import com.Studenspring.service.StudentService;
import com.Studenspring.stucture.ResponseStructure;


@Controller
public class Conntroller {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/viewstu/{id}")
	
	public String getStudentById(@PathVariable int id,Model model){
		ResponseStructure<Student> rs=studentService.getStudentById(id);
		Student stu=rs.getData();
		model.addAttribute("stuobj" ,stu);
		return "StudentView";
		
	}
	

	@GetMapping("/")
	public String getallStudent(Model model){
		ResponseStructure<List<Student>> rs=studentService.getAllStudent();
		List<Student> stulist=rs.getData();
		model.addAttribute("stulistobj" ,stulist);
		return "StudentViewAll";
		
	}

	@GetMapping("/stuform")
	
	public String showStudentForm(@ModelAttribute("student")Student student) {
		return "StudentForm";
	}
	
	@PostMapping("/addstu")
	public String addStudent(@ModelAttribute("Student")Student student,Model model) {
		studentService.saveStudent(student);
		getallStudent(model);
		return "StudentViewAll";
	}
	
	@GetMapping("/editstu/{id}")
	public String showUpdateForm(@PathVariable int id,Model model) {
		ResponseStructure<Student> rs=studentService.getStudentById(id);
		Student stu=rs.getData();
		model.addAttribute("stuobj",stu);
		return "StudentFormUpdate";
	}
	
	@PostMapping("/updatestu")
	public String updateStudent(@ModelAttribute("Student") Student student,Model model) {
		studentService.updateStudent(student, student.getId());
		getallStudent(model);
		return "StudentViewAll";
	}
	
	@GetMapping("/deletestu/{id}")
	public String deleteStudent(@PathVariable int id,Model model) {
		studentService.deleteStudent(id);
		getallStudent(model);
		return "StudentViewAll";
	}
	
	
	
}
	


