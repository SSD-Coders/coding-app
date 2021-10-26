package com.example.init.models;

import javax.persistence.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coder_id")
    private Coders applicationUser;

    private String body;

    private String createdAt;
//    @ManyToOne
//    @JoinTable(name = "Comment", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "comment_id"))
//    Post post;
    @OneToMany(mappedBy = "post" , fetch = FetchType.EAGER)
    private List<Comment> comments;

//    public Post(Post post, String body) {
//        this.post = post;
//        this.body = body;
//    }

//    public Post getPost() {
//        return post;
//    }

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

//    public void setPost(Post post) {
//        this.post = post;
//    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
