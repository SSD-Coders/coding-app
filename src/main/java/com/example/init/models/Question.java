package com.example.init.models;

public class Question {

    public Long quesId;
    public String question;
    public String answer_a;
    public String answer_b;
    public String answer_c;
    public String answer_d;
    public String correct_answer;

    public String answer;

    public Question(Long quesId, String question, String answer_a, String answer_b, String answer_c, String answer_d,
            String correct_answer) {
        this.quesId = quesId;
        this.question = question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.correct_answer = correct_answer;
    }

    public Question() {
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQuesId() {
        return quesId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Question{" + "quesId=" + quesId + ", question='" + question + '\'' + ", answer_a='" + answer_a + '\''
                + ", answer_b='" + answer_b + '\'' + ", answer_c='" + answer_c + '\'' + ", answer_d='" + answer_d + '\''
                + ", correct_answer='" + correct_answer + '\'' + ", answer='" + answer + '\'' + '}';
    }
}
