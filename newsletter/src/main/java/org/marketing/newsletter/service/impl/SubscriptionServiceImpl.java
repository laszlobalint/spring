package org.marketing.newsletter.service.impl;

import org.marketing.newsletter.model.Subscription;
import org.marketing.newsletter.repository.SubscriptionRepository;
import org.marketing.newsletter.service.SubscriptionService;
import org.marketing.newsletter.service.exception.SubscriptionAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.validation.constraints.Min;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private  SubscriptionRepository repository;

    @Override
    @Transactional(rollbackFor = SubscriptionAlreadyExistsException.class)
    public void register(Subscription subscription) throws SubscriptionAlreadyExistsException {

        Assert.notNull(subscription, "Subscription must not be null!");

        logger.info("Registering subscription: {}", subscription);

        try {
            repository.save(subscription);
        } catch (DuplicateKeyException duplicate) {
            logger.error("Error during subscription: {}", duplicate);
            throw new SubscriptionAlreadyExistsException("Subscription already exists with e-mail address: " + subscription.getEmailAddress());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public @Min(0) long getNumbersOfSubscriptions() {
        return repository.count();
    }
}
