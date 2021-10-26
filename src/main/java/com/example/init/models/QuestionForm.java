package com.example.init.models;

import java.util.List;

public class QuestionForm {
    private List<QuizDTO> questions;

    public List<QuizDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuizDTO> questions) {
        this.questions = questions;
    }
}
