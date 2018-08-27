package org.marketing.newsletter.repository.impl;

import org.marketing.newsletter.model.Newsletter;
import org.marketing.newsletter.repository.NewsLetterRepository;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ConfigurationProperties(prefix = "communication")
public class ConfigurationBasedNewsletterRepository implements NewsLetterRepository {

    private List<Newsletter> recentNewsletters;

    @Override
    public List<Newsletter> getRecentNewsletters() {
        return recentNewsletters;
    }

    public void setRecentNewsletters(List<Newsletter> recentNewsletters) {
        this.recentNewsletters = recentNewsletters;
    }
}
