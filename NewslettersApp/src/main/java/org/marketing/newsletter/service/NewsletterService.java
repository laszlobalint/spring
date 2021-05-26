package org.marketing.newsletter.service;

import org.marketing.newsletter.model.Newsletter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
public interface NewsletterService {

    @NotNull
    List<Newsletter> getRecentNewsletters();
}
