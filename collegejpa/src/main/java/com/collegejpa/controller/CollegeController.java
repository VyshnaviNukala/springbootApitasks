package com.collegejpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegejpa.model.College;
import com.collegejpa.model.Student;
import com.collegejpa.service.CollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService collegeservice;
	
	@PostMapping("/colleges")
	public ResponseEntity<College> createCollege(@RequestBody College college){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(collegeservice.createCollege(college));
	}
	
	@PostMapping("/colleges/{collegeId}/students")
	public ResponseEntity<Student> createStudent(@PathVariable Long collegeId, @RequestBody Student student){
		Student ss=collegeservice.createStudent(collegeId, student);
		if(ss==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(ss);
	}
   
	@GetMapping("/colleges")
	public ResponseEntity<List<College>> getAllColleges(){
		return ResponseEntity.ok().body(collegeservice.getAllColleges());
	}
	@GetMapping("/colleges/student/{CollegeName}")
	public ResponseEntity<List<Student>> getStudentByCollegename(@PathVariable String CollegeName){
		return ResponseEntity.ok().body(collegeservice.getAllStudents(CollegeName));
	}
}
