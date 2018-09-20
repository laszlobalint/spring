package com.springview.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.springview.domain.Story;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends CrudRepository<Story, Long> {

	// Query: SELECT * FROM story;
	List<Story> findAll();
	
	// Query: SELECT * FROM story WHERE posted IN (SELECT max(posted) FROM story) LIMIT 1;
	Story findFirstByOrderByPostedDesc();

	// Query: SELECT * FROM story WHERE title = 'title';
	Story findByTitle(String title);
}