package com.stumic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stumic.model.Book;

import com.stumic.repository.BookRepository;

@RestController
public class BookController {

	
	@Autowired
	private BookRepository bookrepository;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getBook(){
		return ResponseEntity.ok().body(bookrepository.findAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book b){
		
		return ResponseEntity.ok().body(bookrepository.save(b));
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBookId(@PathVariable Long id){
		Book b=bookrepository.findById(id).orElseGet(null);
		if(b==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(b);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book b){
		return bookrepository.findById(id).map(eb->{
			eb.setTitle(b.getTitle());
			eb.setAuthor(b.getAuthor());
			
			Book books=bookrepository.save(eb);
			return ResponseEntity.ok().body(books);
		}).orElse(ResponseEntity.notFound().build());
	}
	//orrrr
//	@PutMapping("/update")
//	public ResponseEntity<Book> updateBook( @RequestBody Book b){
//		Book books=bookrepository.saveAndFlush(b);
//		return ResponseEntity.ok().body(books);
//	}
	 
//	 @DeleteMapping("delete/{id}")
//	   public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
//		   if(bookrepository.existsById(id)) {
//			   bookrepository.deleteById(id);
//			   return ResponseEntity.ok().build();
//		   }
//			return ResponseEntity.notFound().build();
//	     }
//	   
	 //orrrr
	@DeleteMapping("/book")
	public ResponseEntity<Book> deleteBook(@RequestBody Book book) {
	    if (bookrepository.existsById(book.getId())) {
	    	  bookrepository.delete(book);
	    	   return ResponseEntity.ok(book);	         
	    }
	  
	    return ResponseEntity.notFound().build();
	}

	 
	 
    @DeleteMapping("/deleteall")
    public ResponseEntity<Void> deleteAll(){
		 bookrepository.deleteAll();
		 return ResponseEntity.ok().build();
	 }
	 
	
	
}

