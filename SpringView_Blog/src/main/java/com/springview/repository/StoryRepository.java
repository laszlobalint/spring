package com.springview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.springview.domain.Story;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {

	List<Story> findAll();
	
	Story findFirstByOrderByPostedDesc();

	// @Query(value = "select * from story where title = ?1 limit 1;", nativeQuery = true)
	// @Query(value = "select s from Story where s.title = :title limit 1;")
	@Query(value = "select * from story where title = :title limit 1;", nativeQuery = true)
	Story findByTitle(@Param("title") String title);

	List<Story> findAllByBloggerNameIgnoreCaseOrderByPostedDesc(String name);
}