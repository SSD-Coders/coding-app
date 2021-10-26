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

    public String username;
    public int totalCorrect = 0;

    public ResultsQuiz() {
        super();
    }

    public ResultsQuiz(int id, String username, int totalCorrect) {
        super();
        this.id = id;
        this.username = username;
        this.totalCorrect = totalCorrect;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }
}
