package org.marketing.newsletter.repository;

import org.marketing.newsletter.model.Newsletter;

import java.util.List;

public interface NewsLetterRepository {

    List<Newsletter> getRecentNewsletters();
}
