package org.marketing.newsletter.controller;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.marketing.newsletter.model.Subscription;
import org.marketing.newsletter.service.SubscriptionService;
import org.marketing.newsletter.service.exception.SubscriptionAlreadyExistsException;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Locale;

@RunWith(SpringRunner.class)
@WebMvcTest(SubscriptionController.class)
public class SubscriptionControllerTest {

    private static final String PATH_SUBSCRIPTION_FORM = "/subscribe";
    private static final String PATH_CONFIRMATION_PAGE = "/confirmation";

    private static final String FORM_FIELD_FULL_NAME = "fullName";
    private static final String FORM_FIELD_EMAIL_ADDRESS = "emailAddress";

    private static final String VIEW_SUBSCRIPTION_FORM = "subscription-form";
    private static final String VIEW_CONFIRMATION_PAGE = "confirmation";
    private static final String VIEW_SUBSCRIPTION_DUPLICATE = "error/error-subscription-already-exists";

    private static final String CONTENT_TYPE_HTML_UTF8 = "text/html;charset=UTF-8";


    @Autowired
    private MockMvc mvc;

    @MockBean
    private SubscriptionService subscriptionService;

    private ResultActions result;

    private void given_theUserIsOnTheSubscriptionPage() throws Exception {
        result = mvc.perform(
                get(PATH_SUBSCRIPTION_FORM)
                .accept(MediaType.TEXT_HTML)
                .locale(Locale.ENGLISH))

                .andDo(print())
                .andExpect(content().contentType(CONTENT_TYPE_HTML_UTF8))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEW_SUBSCRIPTION_FORM));
    }

    private void then_theFormContains(final Subscription subscription) throws Exception {
        result  .andExpect(xpath("//input[@name='" + FORM_FIELD_FULL_NAME + "']/@value").string(subscription.getFullName()))
                .andExpect(xpath("//input[@name='" + FORM_FIELD_EMAIL_ADDRESS + "']/@value").string(subscription.getEmailAddress()));

    }

    @Test
    public void testSubscriptionFormIsEmptyWhenSubscriptionFormIsOpened() throws Exception {
        given_theUserIsOnTheSubscriptionPage();
        then_theFormContains(new Subscription("", ""));
        then_subscriptionIsNotSentToTheService();
    }

    private void when_userSubmitsSubscriptionFormContaining(final Subscription subscriptionFormInput) throws Exception {
        result = mvc.perform(
                post(PATH_SUBSCRIPTION_FORM)
                .accept(MediaType.TEXT_HTML)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param(FORM_FIELD_FULL_NAME, subscriptionFormInput.getFullName())
                .param(FORM_FIELD_EMAIL_ADDRESS, subscriptionFormInput.getEmailAddress()));
    }

    private void then_theUserIsRedirectedToTheConfirmationPage() throws Exception {
        result  .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl(PATH_CONFIRMATION_PAGE));
    }

    @Test
    public void testSubscriptionFormTakesCorrectlySubmittedData() throws Exception {
        given_theUserIsOnTheSubscriptionPage();
        Subscription validSubscription = new Subscription("John Brownie", "johnnyboy@freemail.hu");
        when_userSubmitsSubscriptionFormContaining(validSubscription);
        then_subscriptionIsSentToTheService(validSubscription);
        then_theUserIsRedirectedToTheConfirmationPage();
    }

    private void then_theRegistrationIsRefusedDueToBadRequest() throws Exception {
        result  .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(xpath("//div[@class='formErrorMessage']").exists());
    }

    private void then_fieldErrorDisplayedFor(String fieldName) throws Exception {
        result.andExpect(xpath("//div[@class='fieldErrorMessage']/following-sibling::*[position()=1][@name'" + fieldName + "']").exists());
    }

    private void then_fieldErrorNotDisplayedFor(String fieldName) throws Exception {
        result.andExpect(xpath("//div[@class='fieldErrorMessage']/following-sibling::*[position()=1][@name'" + fieldName + "']").doesNotExist());
    }

    @Test
    public void testSubscriptionFormRefusesInputWithMissingFullName() throws Exception {
        given_theUserIsOnTheSubscriptionPage();

        final Subscription subscriptionWithMissingName = new Subscription("", "boxertommy@gmail.com");
        when_userSubmitsSubscriptionFormContaining(subscriptionWithMissingName);

        then_theRegistrationIsRefusedDueToBadRequest();
        then_fieldErrorDisplayedFor(FORM_FIELD_FULL_NAME);
        then_fieldErrorNotDisplayedFor(FORM_FIELD_EMAIL_ADDRESS);
        then_theFormContains(subscriptionWithMissingName);
        then_subscriptionIsNotSentToTheService();
    }

    private void then_subscriptionIsSentToTheService(final Subscription subscription) throws SubscriptionAlreadyExistsException {
        verify(subscriptionService, times(1)).register(subscription);
    }

    private void then_subscriptionIsNotSentToTheService() throws  SubscriptionAlreadyExistsException {
        verify(subscriptionService, times(0)).register(ArgumentMatchers.any());
    }

    private void given_aSubscriptionAlreadyExitstsWith(String alreadyExistingEmailAddress) throws SubscriptionAlreadyExistsException {
        doThrow(new SubscriptionAlreadyExistsException(null))
                .when(subscriptionService)
                .register(argThat(subscription -> subscription.getEmailAddress().equals(alreadyExistingEmailAddress)));
    }

    private void then_userSeesThatTheEmailAddressIsAlreadyRegistered() throws Exception {
        result  .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(view().name(VIEW_SUBSCRIPTION_DUPLICATE));
    }

    @Test
    public void testSubscriptionRefusedDueToDuplication() throws Exception {
        final Subscription duplicateSubscription = new Subscription("Robin Hood", "sharewood@england.com");
        given_theUserIsOnTheSubscriptionPage();
        given_aSubscriptionAlreadyExitstsWith(duplicateSubscription.getEmailAddress());
        when_userSubmitsSubscriptionFormContaining(duplicateSubscription);
        then_subscriptionIsSentToTheService(duplicateSubscription);
        then_userSeesThatTheEmailAddressIsAlreadyRegistered();
    }
}
