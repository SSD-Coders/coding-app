package com.example.init.models;


import java.util.List;

public class Quiz {

    public int id;
    public String question;

    public String description;


    public Quiz(String question , String description ) {
        this.question = question;
        this.description = description;


    }

    private static class Answers {
        public String answer_a;
        public String answer_b;
        public String answer_c;
        public String answer_d;
        public Object answer_e;
        public Object answer_f;
    }

    private static class CorrectAnswers {
        public String answer_a_correct;
        public String answer_b_correct;
        public String answer_c_correct;
        public String answer_d_correct;
        public String answer_e_correct;
        public String answer_f_correct;
    }

    private static class Tag {
        public String name;
    }

}