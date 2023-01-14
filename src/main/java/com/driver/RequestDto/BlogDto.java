package com.driver.RequestDto;

import java.util.Date;

public class BlogDto {
    public int id;
    private String title;
    private String content;


    public BlogDto(int id,String title,String content) {
        this.id = id;
        this.title=title;
        this.content=content;

    }

    public BlogDto() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
