package org.marketing.newsletter.model;

public class Newsletter {

    private String subject;
    private String content;

    public Newsletter(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public Newsletter() {
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Newsletter: " + "Subject - " + subject + '\'' +
                ", Content - " + content + '\'';
    }
}
