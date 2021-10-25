package com.example.init.models;


import javax.persistence.*;

@Entity
@Table(name = "results")
public class ResultsQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private int id;
    private String username;
    private int totalCorrect;

    public ResultsQuiz() {
    }

    public ResultsQuiz(int id ,String username, int totalCorrect) {
        this.id = id;
        this.username = username;
                this.totalCorrect = totalCorrect;
    }

    public int getId() {
        return id;
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
    //    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
