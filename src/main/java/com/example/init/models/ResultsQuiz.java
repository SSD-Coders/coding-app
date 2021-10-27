package com.example.init.models;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class ResultsQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "username_id")
    public Coders username;
    public int totalCorrect;

    public ResultsQuiz() {
    }

    public ResultsQuiz(int id, Coders username, int totalCorrect) {
        this.id = id;
        this.username = username;
        this.totalCorrect = totalCorrect;
    }

    public int getId() {
        return id;
    }

    public Coders getUsername() {
        return username;
    }

    public void setUsername(Coders username) {
        this.username = username;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
    }
    // public Long getId() {
    // return id;
    // }
    //
    // public void setId(Long id) {
    // this.id = id;
    // }
}
