package org.marketing.newsletter.repository.impl;

import org.marketing.newsletter.model.Newsletter;
import org.marketing.newsletter.repository.NewsletterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class NewsletterRepositoryImpl implements NewsletterRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<Newsletter> mapper = new RowMapper<Newsletter>() {

        @Override
        public Newsletter mapRow(ResultSet rs, int rowNum) throws SQLException {
            Newsletter n = new Newsletter();
            n.setContent(rs.getString("content"));
            n.setSubject(rs.getString("subject"));
            return n;
        }
    };

    @Override
    public @NotNull List<Newsletter> getNewslettersForPeriodOrderedByDescendingPublishingDateLimitedByMaxRecordCount(@NotNull LocalDate fromDate, @NotNull LocalDate toDate, @Min(1) @Max(10) int maxRecords) {

        final  String sql = "SELECT subject, content FROM newsletters WHERE publishingdate >= ? " +
                "AND publishingdate <= ? ORDER BY publishingdate DESC LIMIT ?";

        return jdbcTemplate.query(sql, mapper, fromDate, toDate, maxRecords);
    }
}
