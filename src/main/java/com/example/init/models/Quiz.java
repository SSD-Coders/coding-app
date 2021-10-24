package com.example.init.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.persistence.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    public String answers;
    public String question;
//    public String answers;
    public String answer_a;
    public String answer_b;
    public String answer_c;
    public String answer_d;
    public String answer_e;
    public String answer_f;

//    public String getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(String answers) {
//        this.answers = answers;
//    }

    public Quiz(String question, String answer_a, String answer_b, String answer_c, String answer_d, String answer_e, String answer_f) {
        this.question = question;
//        this.answers = answers;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.answer_e = answer_e;
        this.answer_f = answer_f;
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
