package com.example.init.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.persistence.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public String question;
//    public String answers;

    public Quiz(String question) {
        this.question = question;
//        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

//    public String url = "https://quizapi.io/api/v1/questions?apiKey=phkL2Z69NDCrImLlfnLoElQkoF3StoJlQrAeKvkf&limit=5&css";

    public Quiz() {
    }

//    public String getAnswers() {
//        return answers;
//    }

//    public void setAnswers(String answers) {
//        this.answers = answers;
//    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
