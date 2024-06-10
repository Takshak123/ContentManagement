package com.example.ContentManagement.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Date publishDate;
    private String status;
    private String banner;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    // Getters and Setters

    public Article(Long id, String title, String description, Date publishDate, String status, String banner, Author author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
        this.status = status;
        this.banner = banner;
        this.author = author;
    }

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
