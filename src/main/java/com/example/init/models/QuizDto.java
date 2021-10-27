package com.example.init.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "questions")
public class QuizDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    public Long quesId;
    public String question;
    public String answer_a;
    public String answer_b;
    public String answer_c;
    public String answer_d;
    public String answer_e;
    public String answer_f;
    public String correct_answer;
    public int chose = -1;
    public String answer;

    @OneToOne(orphanRemoval = true)
    @JoinColumn
    private ApplicationUser application_user_id;

    public ApplicationUser getApplication_user_id() {
        return application_user_id;
    }

    public void setApplication_user_id(ApplicationUser application_user_id) {
        this.application_user_id = application_user_id;
    }


    public QuizDto(Long quesId, String question, String answer_a, String answer_b, String answer_c, String answer_d, String answer_e, String answer_f, String correct_answer, int chose) {
        super();
        this.quesId = quesId;
        this.question = question;
        this.answer_a = answer_a;
        this.answer_b = answer_b;
        this.answer_c = answer_c;
        this.answer_d = answer_d;
        this.answer_e = answer_e;
        this.answer_f = answer_f;
        this.correct_answer = correct_answer;
        this.chose = chose;
    }

    public QuizDto() {
        super();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQuesId() {
        return quesId;
    }

    public void setQuesId(Long quesId) {
        this.quesId = quesId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer_a() {
        return answer_a;
    }

    public void setAnswer_a(String answer_a) {
        this.answer_a = answer_a;
    }

    public String getAnswer_b() {
        return answer_b;
    }

    public void setAnswer_b(String answer_b) {
        this.answer_b = answer_b;
    }

    public String getAnswer_c() {
        return answer_c;
    }

    public void setAnswer_c(String answer_c) {
        this.answer_c = answer_c;
    }

    public String getAnswer_d() {
        return answer_d;
    }

    public void setAnswer_d(String answer_d) {
        this.answer_d = answer_d;
    }

    public String getAnswer_e() {
        return answer_e;
    }

    public void setAnswer_e(String answer_e) {
        this.answer_e = answer_e;
    }

    public String getAnswer_f() {
        return answer_f;
    }

    public void setAnswer_f(String answer_f) {
        this.answer_f = answer_f;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public int getChose() {
        return chose;
    }

    public void setChose(int chose) {
        this.chose = chose;
    }

    @Override
    public String toString() {
        return "QuizDto{" +
                "quesId=" + quesId +
                ", question='" + question + '\'' +
                ", answer_a='" + answer_a + '\'' +
                ", answer_b='" + answer_b + '\'' +
                ", answer_c='" + answer_c + '\'' +
                ", answer_d='" + answer_d + '\'' +
                ", answer_e='" + answer_e + '\'' +
                ", answer_f='" + answer_f + '\'' +
                ", correct_answer='" + correct_answer + '\'' +
                ", chose=" + chose +
                '}';
    }
}
