package com.springview.service;

import java.util.Date;
import java.util.List;

import com.springview.domain.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springview.domain.Story;
import com.springview.repository.BloggerRepository;
import com.springview.repository.StoryRepository;

import javax.annotation.PostConstruct;

@Service
public class StoryService {

	private StoryRepository storyRepo;
	private BloggerRepository bloggerRepo;

	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}

	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	public Story getStory(){
		return storyRepo.findFirstByOrderByPostedDesc();
	}

	public Story getSpecificStory(String title) {
		return storyRepo.findByTitle(title);
	}

	public List<Story> getStoriesByBloggerName(String name) { return storyRepo.findAllByBloggerNameIgnoreCaseOrderByPostedDesc(name); }

	// @PostConstruct
	// public void init() {
	//	Blogger startBlogger = new Blogger("Administrator", 100);
	//	bloggerRepo.save(startBlogger);
	//	Story startStory = new Story("First Test And Placeholder Article", "Sample content which was created during the initialization of the services in the Java code.", new Date(), startBlogger);
	//	storyRepo.save(startStory);
	// }
}