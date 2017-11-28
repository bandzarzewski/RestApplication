package com.newssystem.server.NewsSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class Comment {
    @Id
    private String id;
    @NotNull(message = "Brak NewsId")
    private String NewsId;
    @NotNull
    @Size(min = 10, max = 1000)
    private String comment;
    @NotNull
    @Size(min = 1)
    private String author;
    private String data;

    public Comment() {
    }

    public Comment(String newsId, String comment, String author, String data) {
        NewsId = newsId;
        this.comment = comment;
        this.author = author;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return NewsId;
    }

    public void setNewsId(String newsId) {
        NewsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
