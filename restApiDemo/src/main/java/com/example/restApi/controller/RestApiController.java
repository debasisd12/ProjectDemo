package com.example.restApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.model.BookDetails;
import com.example.restApi.service.RestApiService;

@RestController
@RequestMapping(value="/restApi/v1")
public class RestApiController {

	@Autowired
	private RestApiService servApi;
	
	@GetMapping(value="/books")
	public List<BookDetails> getAllBookDetails()
	{
		return servApi.findAllBookDetailsService();
	}
	
}
