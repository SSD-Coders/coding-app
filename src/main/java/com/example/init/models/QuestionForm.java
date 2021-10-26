package com.example.init.models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionForm {

    private List<QuizDto> questions;

    public List<QuizDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizDto> questions) {
        this.questions = questions;
    }
}
