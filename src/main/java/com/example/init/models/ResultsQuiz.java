package com.example.init.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "results")
public class ResultsQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "username_id")
    public ApplicationUser user;
    public int totalCorrect = 0;

    public ResultsQuiz() {
        super();
    }

    public ResultsQuiz(int id, ApplicationUser username, int totalCorrect) {
        super();
        this.id = id;
        this.user = user;
        this.totalCorrect = totalCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ApplicationUser getUser() {
        return user;
    }

    public void setUser(ApplicationUser user) {
        this.user = user;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }
}
