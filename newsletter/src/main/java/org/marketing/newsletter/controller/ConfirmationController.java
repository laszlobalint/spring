package org.marketing.newsletter.controller;

import org.marketing.newsletter.repository.NewsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfirmationController {

    @Value("${subscription.numberOfSubscriptions}")
    private long numberOfSubscriptions;

    @Autowired
    private NewsLetterRepository newsLetterRepository;

    @GetMapping(value = "/confirmation")
    public String getConfirmation(Model model) {
        model.addAttribute("numberOfSubscriptions", numberOfSubscriptions);
        model.addAttribute("newsletterHiglights", newsLetterRepository.getRecentNewsletters());
        return "confirmation";
    }
}
