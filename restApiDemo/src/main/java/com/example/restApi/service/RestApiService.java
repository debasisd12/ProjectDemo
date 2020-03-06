package com.example.restApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restApi.model.BookDetails;
import com.example.restApi.repository.RestApiRepository;

@Service
public class RestApiService {
    @Autowired
	private RestApiRepository repoApi;

	public List<BookDetails> findAllBookDetailsService() {
		
		return (List<BookDetails>) repoApi.findAll();
	}

	public List<BookDetails> findByTitleContaining(String title) {
		
		return repoApi.findByTitleContaining(title);
	}

	public Optional<BookDetails> findBookDetailsById(int bid) {
		
		return repoApi.findById(bid);
	}

	public BookDetails addNewBookDetails(BookDetails bDetails) {
		/*
		 * String requestedBookName=bDetails.getBookName(); String
		 * requestedBookEdition=bDetails.getBookEdition(); String
		 * requestedBookAuthor=bDetails.getBookAuthor(); String
		 * requestedBookDesc=bDetails.getBookDescription();
		 */
    	
    	BookDetails bdetails = repoApi.save(bDetails);
    	
		return bdetails;
	}

}
