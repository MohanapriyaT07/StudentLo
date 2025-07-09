package com.Studenspring.studentdao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Studenspring.entity.Student;
import com.Studenspring.repository.StudentRepository;

@Repository
public class StudentDao {
	@Autowired
	StudentRepository studentRepository;
	
	
	public Student saveStudent(Student student){
		return studentRepository.save(student);
	}
	public Student getStudentById(int id) {
		Optional<Student> optional=studentRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}else return optional.get();
	}

public List<Student>getAllStudent(){
	return studentRepository.findAll();
}
public Student updateStudent(Student student,int id) {
	Student existingstudent=getStudentById(id);
	if(existingstudent !=null) {
		existingstudent.setName(student.getName()); 
		existingstudent.setEmail(student.getEmail());
		return studentRepository.save(existingstudent);
	}
	else return null;
}

public  Boolean deleteStudent(int id) {
	Optional<Student> optional=studentRepository.findById(id);
	if(optional.isPresent()) {
		studentRepository.delete(optional.get());
		return true;
	}else return false;
}
}


