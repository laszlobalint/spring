package hello.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Email {
    private String status;
    private String query;
    private Long results;
    private ArrayList<EmailData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getResults() {
        return results;
    }

    public void setResults(Long results) {
        this.results = results;
    }

    public ArrayList<EmailData> getData() {
        return data;
    }

    public void setData(ArrayList<EmailData> data) {
        this.data = data;
    }
}
