package com.example.restApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.restApi.model.BookDetails;

@Repository
public interface RestApiRepository extends CrudRepository<BookDetails, Integer> {

}
