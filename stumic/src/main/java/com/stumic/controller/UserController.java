//package com.stumic.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.stumic.model.Users;
//import com.stumic.service.UserService;
//
//@RestController
//public class UserController {
//   @Autowired
//   private UserService userservice;
//   
//   @PostMapping("/user") 
//   public ResponseEntity<Users> addUser(@RequestBody Users user){
//	   return ResponseEntity.ok().body(userservice.create(user));
//   }
//   
//   @GetMapping("/user") 
//   public ResponseEntity<List<Users>> getAllUser() {
//	  return ResponseEntity.ok().body( userservice.getAll()) ;
//	   
//   }
//   
//   @GetMapping("/user/{id}") 
//   public ResponseEntity<Users> getUserById(@PathVariable Long id) {
//	  Users u= userservice.getUserId(id);
//	  if(u==null) {
//		 return ResponseEntity.notFound().build();
//	  }
//	  return ResponseEntity.ok().body(u);   
//   }
//   
//   @PutMapping("/update/{id}")
//   public ResponseEntity<Users> UpdateUserById(  @PathVariable Long id, @RequestBody Users user) {
//	  Users users= userservice.updateUser(id, user);
//	  if(users==null) {
//			 return ResponseEntity.notFound().build();
//		  }
//		  return ResponseEntity.ok().body(users);   
//	   }
//   
//   @DeleteMapping("delete/{id}")
//   public ResponseEntity<Void> Book(@PathVariable Long id) {
//	   Users du= userservice.deleteById(id);
//		  if(du==null) {
//				 return ResponseEntity.notFound().build();
//			  }
//			  return ResponseEntity.ok().build();  
//     }
//   


//   
//   
//   
//   @DeleteMapping("/deleteuser") 
//   public ResponseEntity<Void> UserDelete() { 
//	   userservice.deleteAll();
//	  return  ResponseEntity.noContent().build();
//   }
//   
//}



////2 
////vysh          
////vysh@gmail
//
////-updateUserById(2),{"vyshnavi","vyshnavi@gmil.com"
//arr= {1,2,3}
//arr.map(e->(return e+1))











