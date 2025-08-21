package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query(value = "select s from Student s where s.name=?1")
	public List<Student> selectusingname(String name);
}
