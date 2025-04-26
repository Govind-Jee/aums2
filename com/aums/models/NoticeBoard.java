package com.aums.models;

import java.sql.Date;

public class NoticeBoard {
    private String notice_id;
    private String department_id;
    private Date date_posted;
    private String content;

    public String getNotice_id() { return notice_id; }

    public void setNotice_id(String notice_id) { this.notice_id = notice_id; }

    public String getDepartment_id() { return department_id; }

    public void setDepartment_id(String department_id) { this.department_id = department_id; }

    public Date getDate_posted() { return date_posted; }

    public void setDate_posted(Date date_posted) { this.date_posted = date_posted; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}
