package com.example.init.models;

import lombok.Data;

@Data
public class Answers {

    public String answear_a;
    public String answear_b;
    public String answear_c;
    public String answear_d;
    public String answear_e;
    public String answear_f;

    public  Answers(String answear_a, String answear_b, String answear_c, String answear_d, String answear_e, String answear_f) {
        this.answear_a = answear_a;
        this.answear_b = answear_b;
        this.answear_c = answear_c;
        this.answear_d = answear_d;
        this.answear_e = answear_e;
        this.answear_f = answear_f;
    }

    public String getAnswear_a() {
        return answear_a;
    }

    public void setAnswear_a(String answear_a) {
        this.answear_a = answear_a;
    }

    public String getAnswear_b() {
        return answear_b;
    }

    public void setAnswear_b(String answear_b) {
        this.answear_b = answear_b;
    }

    public String getAnswear_c() {
        return answear_c;
    }

    public void setAnswear_c(String answear_c) {
        this.answear_c = answear_c;
    }

    public String getAnswear_d() {
        return answear_d;
    }

    public void setAnswear_d(String answear_d) {
        this.answear_d = answear_d;
    }

    public String getAnswear_e() {
        return answear_e;
    }

    public void setAnswear_e(String answear_e) {
        this.answear_e = answear_e;
    }

    public String getAnswear_f() {
        return answear_f;
    }

    public void setAnswear_f(String answear_f) {
        this.answear_f = answear_f;
    }
}
