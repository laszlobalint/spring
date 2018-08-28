package org.marketing.newsletter.controller;

import org.marketing.newsletter.service.NewsletterService;
import org.marketing.newsletter.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfirmationController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping(value = "/confirmation")
    public String getConfirmation(Model model) {
        model.addAttribute("numberOfSubscriptions", subscriptionService.getNumbersOfSubscriptions());
        model.addAttribute("newsletterHiglights", newsletterService.getRecentNewsletters());
        return "confirmation";
    }
}
