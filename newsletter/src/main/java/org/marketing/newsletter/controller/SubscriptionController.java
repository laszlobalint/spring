package org.marketing.newsletter.controller;

import org.marketing.newsletter.model.Subscription;
import org.marketing.newsletter.service.SubscriptionService;
import org.marketing.newsletter.service.exception.SubscriptionAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class SubscriptionController {

    private static final String SUBSCRIPTION_FORM = "subscription-form";
    private static final String SUBSCRIPTION_FORM_ATTRIBUTE = "subscriptionForm";
    private static final String PATH_SUBSCRIBE = "/subscribe";
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping(value = {"/", PATH_SUBSCRIBE})
    public String getSubscriptionForm(@ModelAttribute(SUBSCRIPTION_FORM_ATTRIBUTE) Subscription sub) {
        return SUBSCRIPTION_FORM;
    }

    @PostMapping(PATH_SUBSCRIBE)
    public String submitSubscription(@ModelAttribute(SUBSCRIPTION_FORM_ATTRIBUTE) @Valid Subscription subscription, BindingResult result, HttpServletResponse response) {

        logger.debug("User submitted the subscription: {}", subscription);

        String targetView = SUBSCRIPTION_FORM;

        if (result.hasErrors()) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            result.reject("subscriptionForm.error.incompleteInput");
            return SUBSCRIPTION_FORM;
        } else {
            try {
                subscriptionService.register(subscription);
                return "redirect:/confirmation";
            } catch (SubscriptionAlreadyExistsException e) {
                result.reject("error.userError.subscriber.already.exists");
            }
        }
        return targetView;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String subscriptionAlreadyExists(SubscriptionAlreadyExistsException e) {
        return "error/error-subscription-already-exists";
    }
}
