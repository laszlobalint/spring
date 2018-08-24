package org.marketing.newsletter.repository;

import org.marketing.newsletter.model.Subscription;
import org.marketing.newsletter.service.exception.SubscriptionAlreadyExistsException;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
public interface SubscriptionRepository {

    void save(@NotNull @Valid Subscription subscription) throws SubscriptionAlreadyExistsException;
}
