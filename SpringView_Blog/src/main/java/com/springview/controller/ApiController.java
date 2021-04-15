package com.springview.controller;

import com.springview.domain.Story;
import com.springview.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private StoryService storyService;

    @Autowired
    public void setStoryService(StoryService storyService) {
        this.storyService = storyService;
    }

    @RequestMapping("/api")
    public List<Story> stories() {
        return storyService.getStories();
    }

    @RequestMapping("/api/story")
    public Story story() {
        return storyService.getStory();
    }

    @RequestMapping("/api/title/{title}")
    public Story searchForStory(@PathVariable(value = "title") String title) throws Exception {
        return storyService.getSpecificStory(title);
    }

    @RequestMapping("/api/stories/{name}")
    public List<Story> searchForStoriesByBloggerName(@PathVariable(value = "name") String name) throws Exception {
        return storyService.getStoriesByBloggerName(name);
    }
}