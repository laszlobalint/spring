package org.marketing.newsletter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.marketing.newsletter.model.Subscription;
import org.marketing.newsletter.service.SubscriptionService;
import org.marketing.newsletter.service.exception.SubscriptionAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionValidationTests {

    @Autowired
    private SubscriptionService service;

    @Test(expected = ConstraintViolationException.class)
    public void test_registrationWithNullSubscription_fails() throws SubscriptionAlreadyExistsException {
        service.register(null);
    }

    @Test(expected = ConstraintViolationException.class)
    public void test_registrationWithNameOfSpaceOnly_fails() throws SubscriptionAlreadyExistsException {
        service.register(new Subscription("", "bloodymary@gmail.com"));
    }

    @Test(expected = ConstraintViolationException.class)
    public void test_registrationWithInvalidEmailAddressFormat_fails() throws SubscriptionAlreadyExistsException {
        service.register(new Subscription("John Dwayne", "gmail.com"));
    }
}
