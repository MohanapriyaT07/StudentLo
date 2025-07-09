package com.Studenspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Studenspring.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
