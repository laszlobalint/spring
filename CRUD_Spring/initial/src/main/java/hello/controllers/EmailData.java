package hello.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmailData {
    private String source_id;
    private String source_url;
    private Long source_lines;
    private Long source_size;
    private String source_network;
    private String source_provider;
    private Boolean verified;
    private String title;
    private String author;
    private Date date_created;
    private Date date_leaked;
    private Long emails_count;
    private String details;

    public String getSource_id() {
        return source_id;
    }

    public void setSource_id(String source_id) {
        this.source_id = source_id;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public Long getSource_lines() {
        return source_lines;
    }

    public void setSource_lines(Long source_lines) {
        this.source_lines = source_lines;
    }

    public Long getSource_size() {
        return source_size;
    }

    public void setSource_size(Long source_size) {
        this.source_size = source_size;
    }

    public String getSource_network() {
        return source_network;
    }

    public void setSource_network(String source_network) {
        this.source_network = source_network;
    }

    public String getSource_provider() {
        return source_provider;
    }

    public void setSource_provider(String source_provider) {
        this.source_provider = source_provider;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_leaked() {
        return date_leaked;
    }

    public void setDate_leaked(Date date_leaked) {
        this.date_leaked = date_leaked;
    }

    public Long getEmails_count() {
        return emails_count;
    }

    public void setEmails_count(Long emails_count) {
        this.emails_count = emails_count;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
