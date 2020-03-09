package com.example.restApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
/*import org.springframework.data.repository.CrudRepository;*/
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.restApi.model.BookDetails;

@Repository
public interface RestApiRepository extends JpaRepository<BookDetails, Integer> {

	@Query(value = "SELECT * FROM book_details WHERE bookname=?1", nativeQuery = true)
	List<BookDetails> findByTitleContaining(String bookname);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update book_details set bookstatus ='inActive' where bookid =:bid", nativeQuery = true)
	void deActiveBookById(int bid);
}
