package com.passportUniDi.controller;


import java.util.List;

import com.passportUniDi.entity.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.passportUniDi.entity.Person;

import com.passportUniDi.service.PersonService;


@RestController
@RequestMapping("/v1")
public class PersonController {
     
	@Autowired
	private PersonService personservice;
	
	@PostMapping("/person")
	public ResponseEntity<Person> createPersons(@RequestBody Person person){
		Person p=personservice.createPerson(person);
		return ResponseEntity.ok().body(p);

	}

//	@PostMapping("/person")
//	public ResponseEntity<Void> create() {
//		personservice.createPersons();
//		return ResponseEntity.ok().build();
//	}

	@GetMapping("/getpersons")
	public ResponseEntity<List<Person>> getallPersons(){
		List<Person> pp =personservice.getall();
		return ResponseEntity.ok().body(pp);
	}

    @GetMapping("/getperson/{passportId}")
	public ResponseEntity<Person> getPersons(@PathVariable String passportId){
		Person ppp=personservice.findPerson(passportId);
		return  ResponseEntity.ok().body(ppp);
	}

//delete with id
@DeleteMapping("/delete/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
	personservice.deletebyid(id);
	return ResponseEntity.ok().build();
}

//delete passport from person
//@DeleteMapping("/delete/{passportId}")
//public ResponseEntity<Void> delete(@PathVariable String passportId) {
//		personservice.deletePersonFromPassport(passportId);
//		return ResponseEntity.ok().build();
//}

@PutMapping("/update/{id}")
	public ResponseEntity<Person> update(@RequestBody Person pp) {
		Person per=personservice.updatePerson(pp);
		return ResponseEntity.ok().body(per);
}
@DeleteMapping("/deleteall")
	public ResponseEntity<Void> deleteall() {
		personservice.Deleteall();
		return ResponseEntity.ok().build();
}
}

