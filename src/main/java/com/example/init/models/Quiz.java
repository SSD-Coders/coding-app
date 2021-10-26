package com.example.init.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import javax.persistence.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quiz {

    public int id;
    public String question;
    public Object description;
    public Answers answers;
    public String multiple_correct_answers;
    public CorrectAnswers correct_answers;
    public String correct_answer;
    public Object explanation;
    public Object tip;
    public List<Tag> tags;
    public String category;
    public String difficulty;
    public int chose = -1;

    public Quiz(int id, String question, Object description, Answers answers, String multiple_correct_answers, CorrectAnswers correct_answers, String correct_answer, Object explanation, Object tip, List<Tag> tags, String category, String difficulty , int chose) {
        this.id = id;
        this.question = question;
        this.description = description;
        this.answers = answers;
        this.multiple_correct_answers = multiple_correct_answers;
        this.correct_answers = correct_answers;
        this.correct_answer = correct_answer;
        this.explanation = explanation;
        this.tip = tip;
        this.tags = tags;
        this.category = category;
        this.difficulty = difficulty;
        this.chose = chose;
    }

    public Quiz() {

    }

    public static class Answers{
        public String answer_a;
        public String answer_b;
        public String answer_c;
        public String answer_d;
        public String answer_e;
        public String answer_f;

    }


    public static class CorrectAnswers{
        public String answer_a_correct;
        public String answer_b_correct;
        public String answer_c_correct;
        public String answer_d_correct;
        public String answer_e_correct;
        public String answer_f_correct;
    }


    private static class Tag{
        public String name;
    }
    }





//        String convertedToString = String.valueOf(answers.answer_a);
////        if (convertedToString.equals(correct_answer))
//        {
////            correct++;
//        }else if (correct_answer.equals(answers.answer_b) ){
//            correct++;
//        }else if (correct_answer.equals(answers.answer_c)) {
//            correct++;
//        }else if (correct_answer .equals(answers.answer_d)) {
//            correct++;
//        }else if (correct_answer.equals(answers.answer_e)) {
//            correct++;
//        }else if (correct_answer.equals(answers.answer_f)) {
//            correct++;
//        }
//        return correct;
//    }






