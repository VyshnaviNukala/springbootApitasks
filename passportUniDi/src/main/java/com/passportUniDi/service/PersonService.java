package com.passportUniDi.service;

import java.sql.Date;
import java.util.List;

import com.passportUniDi.entity.Passport;
import com.passportUniDi.repo.PassportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passportUniDi.entity.Person;
//import com.passportUniDi.repo.PassportRepo;
import com.passportUniDi.repo.PersonRepo;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PersonService {
  @Autowired 
  private PersonRepo personrepo;
  
  @Autowired
  private PassportRepo passportrepo;
  


public Person createPerson(Person person) {
	 return personrepo.save(person);
}

//    public void createPersons() {
////        System.out.println("createPersons called");
//        List<Person> persons = List.of(
//                createPerson("raji", Date.valueOf("2002-01-29"), "mummidivaram", "asdf345", "kkd", Date.valueOf("2024-09-16")),
//                createPerson("hari", Date.valueOf("2003-02-12"), "naramsampet", "lkgd456", "hyd", Date.valueOf("2002-08-13"))
//        );
//        System.out.println("Created person list");
//
//        personrepo.saveAll(persons);
//        System.out.println("Saved sample persons successfully.");
//    }
//
//    private Person createPerson(String name, Date dateOfBirth, String birthPlace,
//                                String passportId, String issuePlace, Date issueDate) {
//        System.out.println("Creating person: " + name);
//        Passport passport = new Passport(passportId, issuePlace, issueDate);
//        Person person = new Person(name, dateOfBirth, birthPlace, passport);
////        System.out.println("hi");
//        return person;
//    }



    public List<Person> getall(){
    return personrepo.findAll();

}

public Person findPerson(String passportId){
  return personrepo.findByPassport_PassportId(passportId);
}

//    delete person by id
    public void deletebyid(Long id) {
        personrepo.deleteById(id);
    }

// delete passport from person
//    public  void deletePersonFromPassport(String passportId) {
//        Person pp= personrepo.findPersonByPassport_PassportId(passportId).orElseThrow(()-> new RuntimeException("Person not found"));
//        pp.setPassport(null);
//        personrepo.save(pp);
//
////        passportrepo.deleteById(passportId);
//
//    }

    public Person updatePerson(Person p) {

       return personrepo.saveAndFlush(p);



    }

public void Deleteall(){
        personrepo.deleteAll();
}
}
