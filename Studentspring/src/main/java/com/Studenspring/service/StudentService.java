package com.Studenspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Studenspring.entity.Student;
import com.Studenspring.stucture.ResponseStructure;
import com.Studenspring.studentdao.StudentDao;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public ResponseStructure<Student>saveStudent(Student student){
		
		ResponseStructure<Student>responseStructure=new ResponseStructure<Student>();
		
		Student student1=studentDao.saveStudent(student);
		
		if(student1!=null) {
			responseStructure.setData(student1);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Http saved sucessfully");
			
		}else {
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Http failed sucessfully");
			
		}return responseStructure;
		
	}
	

	public ResponseStructure<Student>getStudentById(Integer id){
		
		ResponseStructure<Student>responseStructure =new ResponseStructure<Student>();
		
		Student student=studentDao.getStudentById(id);
		
		if(student!=null) {
			responseStructure.setData(student);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Student got by id");
			
		}else {
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Student gotnot  by id");
			
		}return responseStructure;
		
	}
public ResponseStructure<List<Student>>getAllStudent(){
		
		ResponseStructure<List<Student>>responseStructure =new ResponseStructure<List<Student>>();
		
		List<Student> student=studentDao.getAllStudent();
		
		if(student.size()>0) {
			responseStructure.setData(student);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Here are the list of all student");
			
		}else {
			responseStructure.setData(null);
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("No student record exists in database");
			
		}return responseStructure;
		
	}
public ResponseStructure<Student>updateStudent(Student student,Integer id){
	
	ResponseStructure<Student>responseStructure =new ResponseStructure<Student>();
	
	Student student1=studentDao.updateStudent(student, id);
	
	if(student1!=null) {
		responseStructure.setData(student1);
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Student upadated sucessfully");
		
	}else {
		responseStructure.setData(null);
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(" Student donnot exists");
		
	}
	return responseStructure;
	
}

public ResponseStructure<String>deleteStudent(Integer id){
	
	ResponseStructure<String>responseStructure =new ResponseStructure<String>();
	
	boolean isTrue=studentDao.deleteStudent(id);
	
	if(isTrue) {
		responseStructure.setData("Student selected");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Student deleted sucessfully");
		
	}else {
		responseStructure.setData(null);
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage(" Student has failed to get delete");
		
	}return responseStructure;
	
}



}
