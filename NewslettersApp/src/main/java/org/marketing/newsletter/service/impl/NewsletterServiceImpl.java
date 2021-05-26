package org.marketing.newsletter.service.impl;

import org.marketing.newsletter.model.Newsletter;
import org.marketing.newsletter.repository.NewsletterRepository;
import org.marketing.newsletter.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Service
public class NewsletterServiceImpl implements NewsletterService {

    @Autowired
    private NewsletterRepository repository;

    @Value("${numberOfArticlesToShow}")
    private int numberOfArticles;

    @Override
    public @NotNull List<Newsletter> getRecentNewsletters() {
        final LocalDate today = LocalDate.now();
        final LocalDate fromDate = today.minusMonths(4);
        return repository.getNewslettersForPeriodOrderedByDescendingPublishingDateLimitedByMaxRecordCount(fromDate, today, numberOfArticles);
    }
}
