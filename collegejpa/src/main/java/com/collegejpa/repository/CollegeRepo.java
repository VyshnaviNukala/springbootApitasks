package com.collegejpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collegejpa.model.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Long>  {
 
}
