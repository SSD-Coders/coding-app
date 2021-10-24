package com.example.init.models;

import javax.persistence.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_user_id")
    private Coders applicationUser;

    private String body;

    private String createdAt;

    public Post() {
    }

    public Post(Coders applicationUser, String body) {
        this.applicationUser = applicationUser;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm");
        this.createdAt = sdf.format(new Timestamp(System.currentTimeMillis()).getTime());

        this.body = body;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coders getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(Coders applicationUser) {
        this.applicationUser = applicationUser;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
