package com.aums.models;

import java.sql.Date;

public class StudentLibrary {
    private String regno;
    private String book_id;
    private Date issue_date;
    private Date return_date;

    public String getRegno() { return regno; }

    public void setRegno(String regno) { this.regno = regno; }

    public String getBook_id() { return book_id; }

    public void setBook_id(String book_id) { this.book_id = book_id; }

    public Date getIssue_date() { return issue_date; }

    public void setIssue_date(Date issue_date) { this.issue_date = issue_date; }

    public Date getReturn_date() { return return_date; }

    public void setReturn_date(Date return_date) { this.return_date = return_date; }
}
