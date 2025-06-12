package com.passportUniDi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.passportUniDi.entity.Person;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{
   Person findByPassport_PassportId(String passportId);

   Optional<Person> findPersonByPassport_PassportId(String passportId);

}
