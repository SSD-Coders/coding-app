package com.example.init.models;

import javax.persistence.*;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String title;
    private String body;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private ApplicationUser author;

    public ApplicationUser getAuthor() {
        return author;
    }

    public Code(Long id, String title, String body, ApplicationUser author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthor(ApplicationUser author) {
        this.author = author;
    }
}
