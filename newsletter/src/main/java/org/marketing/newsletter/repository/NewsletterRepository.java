package org.marketing.newsletter.repository;

import org.marketing.newsletter.model.Newsletter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Validated
public interface NewsletterRepository {

    @NotNull
    List<Newsletter> getNewslettersForPeriodOrderedByDescendingPublishingDateLimitedByMaxRecordCount(
            @NotNull LocalDate fromDate, @NotNull LocalDate toDate, @Min(1) @Max(10) int maxRecords);
}
