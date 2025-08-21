package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.repo.StudentRepository;

@Service
public class Studentservice {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public long getCount() {
		return studentRepository.count();
	}
	public List<Student> getAllStudents(String name){
		return studentRepository.selectusingname(name);
	}
	
	public Student findStudent(int id) {
		return studentRepository.findById(id).get();
	}
}
