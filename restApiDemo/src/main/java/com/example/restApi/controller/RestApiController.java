package com.example.restApi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.model.BookDetails;
import com.example.restApi.service.RestApiService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value="/restApi/v1")
public class RestApiController {

	@Autowired
	private RestApiService servApi;
	
	@GetMapping(value="/books")
	public ResponseEntity<List<BookDetails>> getAllBookDetails(@RequestParam(required = false) String bookName)
	{
		try {
		      List<BookDetails> bookdetails = new ArrayList<BookDetails>();

		      System.out.println(bookName+"----bookName");
		      if (bookName == null)
		      {
		    	  servApi.findAllBookDetailsService().forEach(bookdetails::add);
		      }
		      else
		      {
		    	  servApi.findByTitleContaining(bookName).forEach(bookdetails::add);
		    	  System.out.println(bookName+"----bookName");
		      }
		      if (bookdetails.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(bookdetails, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}
	
	
	@GetMapping("/books/{bookId}")
	  public ResponseEntity<BookDetails> getBookById(@PathVariable("bookId") int bid) {
	    Optional<BookDetails> BookDetailsData = servApi.findBookDetailsById(bid);

	    if (BookDetailsData.isPresent()) {
	      return new ResponseEntity<>(BookDetailsData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	@PostMapping("/books")
	  public ResponseEntity<BookDetails> createBookDetails(@RequestBody BookDetails bDetails) {
	    try {
	    
	    	BookDetails savedBookDetails =servApi.addNewBookDetails(bDetails) ;
	      return new ResponseEntity<>(savedBookDetails, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  }
	
	@PutMapping("/books/{bookId}")
	  public ResponseEntity<BookDetails> updateBookManagement(@PathVariable("bookId") int bid, @RequestBody BookDetails books) {
	    Optional<BookDetails> BooksData =servApi.findBookDetailsById(bid);

	    if (BooksData.isPresent()) {
	      BookDetails _book = BooksData.get();
	      _book.setBookName(books.getBookName());
	      _book.setBookEdition(books.getBookEdition());
	      _book.setBookAuthor(books.getBookAuthor());
	      _book.setBookDescription(books.getBookDescription());
	      
	      return new ResponseEntity<>(servApi.addNewBookDetails(_book), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
