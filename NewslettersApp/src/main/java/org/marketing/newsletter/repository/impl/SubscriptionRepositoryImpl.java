package org.marketing.newsletter.repository.impl;

import org.marketing.newsletter.model.Subscription;
import org.marketing.newsletter.repository.SubscriptionRepository;
import org.marketing.newsletter.service.exception.SubscriptionAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Min;
import java.util.UUID;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Subscription subscription) throws SubscriptionAlreadyExistsException {
        logger.info("Save {} now..." + subscription);

        final String sql = "INSERT INTO subscriptions (id, fullname, email) VALUES (?, ?, ?)";
        final String id = UUID.randomUUID().toString();

        jdbcTemplate.update(sql, id, subscription.getFullName(), subscription.getEmailAddress());
    }

    @Override
    public @Min(0) long count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM subscriptions", Long.class);
    }
}
