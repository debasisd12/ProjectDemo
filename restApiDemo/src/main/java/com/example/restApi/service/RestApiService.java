package com.example.restApi.service;

import java.util.List;

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

}
