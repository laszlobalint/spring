package org.marketing.newsletter.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Subscription {

    @NotBlank
    @Size(min = 3, max = 30)
    private String fullName;

    @NotBlank
    @Email
    private String emailAddress;

    public Subscription(String fullName, String emailAddress) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
    }

    public Subscription() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Subscription details: " +
                "Full name - " + fullName + '\'' +
                ", E-mail address - " + emailAddress + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(getFullName(), that.getFullName()) &&
                Objects.equals(getEmailAddress(), that.getEmailAddress());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFullName(), getEmailAddress());
    }
}
