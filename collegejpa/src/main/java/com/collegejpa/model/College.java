package com.collegejpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class College {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long collegeId;
 private String name;
 
 @OneToMany(mappedBy="college", cascade=CascadeType.ALL)
 @JsonManagedReference
 private List<Student> students;
 

public College(Long collegeId, String name, List<Student> students) {
	this.collegeId=collegeId;
	this.name=name;
	this.students=students;
	
}
public College() {
	
}
public Long getCollegeId() {
	return collegeId;
}
public void setCollegId(Long collegeId) {
	this.collegeId = collegeId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
 
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}
 

 
 
}
