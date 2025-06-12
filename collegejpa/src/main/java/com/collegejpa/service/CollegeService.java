package com.collegejpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collegejpa.model.College;
import com.collegejpa.model.Student;
import com.collegejpa.repository.CollegeRepo;
import com.collegejpa.repository.StudentRepo;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeRepo collegerepo;
	
	@Autowired
	private StudentRepo studentrepo;
	
	public College createCollege(College college) {
		return collegerepo.save(college);
	}
   
	public Student createStudent(Long collegeId, Student student) {
		College clg=collegerepo.findById(collegeId).orElseGet(null);
		student.setCollege(clg);
		return studentrepo.save(student);
	}
	
	
	public List<College> getAllColleges(){
		return collegerepo.findAll();
	}
	public List<Student> getAllStudents(String collegeName){
		return studentrepo.findByCollegeNameOrderByNameDesc(collegeName);
	}
	
}
