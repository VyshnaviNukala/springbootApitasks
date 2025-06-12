package com.passportUniDi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passportUniDi.entity.Passport;

@Repository
public interface PassportRepo extends JpaRepository<Passport, Long> {

//    void deleteById(String passportId);

}
