package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.service.Studentservice;

@RestController
public class Studentcontroller {
	@Autowired
	private Studentservice studentservice;
	@GetMapping("/test")
	public String test() {
		return "API working";
	}
	
	@PostMapping("/createstudent")
	public Student createStudent(@RequestBody Student student) {
		return studentservice.createStudent(student);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findStudent(@PathVariable int id) {
		
		Map<String, Object> map=new HashMap<>();
		try {
			Student s=studentservice.findStudent(id);
			map.put("Stat_data",10);
			map.put("process","Success");
			map.put("message", "Success");
			
			map.put("data", s);
			
			return new ResponseEntity<>(map,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			map.put("status", 0);
			map.put("message","Data not present");
			map.put("error", e.getMessage());
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/getStudentdetails/{name}")
	public long getallStudentsdetails(@PathVariable String name){
		Map<String, Object> map=new HashMap<>();
		map.put("Stat_data",10);
		map.put("process","Success");
		map.put("message", "Success");
		return studentservice.getCount();
		
		
	}
}
