package org.marketing.newsletter.repository.impl;

import org.marketing.newsletter.model.Subscription;
import org.marketing.newsletter.repository.SubscriptionRepository;
import org.marketing.newsletter.service.exception.SubscriptionAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DummySubscriptionRepositoryImpl implements SubscriptionRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void save(Subscription subscription) throws SubscriptionAlreadyExistsException {
        logger.info("Save {} now..." + subscription);
        System.out.println("Dummy Subscription Repository Implementation saves " + subscription);
    }
}
