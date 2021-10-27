package com.example.init.controllers;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class QuizController {
    int counter = 0;



    @Autowired
    QuestionForm qForm;

public int getMark() {
    Question question = new Question();
    int mark = 0;

    for (Question question1: qForm.getQuestions()) {
        if (question.answer.equals(question1.correct_answer)){
            mark++;
        }

    }
    return mark;
}

@GetMapping("/quiz")
    String getQuizPage(Model model) throws FileNotFoundException {
            Gson gson = new Gson();

        FileReader data = new FileReader("C:\\Users\\STUDENT\\Desktop\\Spring\\Project\\init\\src\\main\\resources\\quiz.json");
        Type jsonCasting = new TypeToken<List<Question>>() {
        }.getType();
        List<Question> jsonList = gson.fromJson(data, jsonCasting);

        if (counter >= jsonList.size()) {
            model.addAttribute("marks" , getMark());

            return "marks";
        }
        model.addAttribute("question" , jsonList.get(counter));


        counter++;
        return "quiz";
}

        @PostMapping("/quiz")
    RedirectView submitQuiz(@ModelAttribute("quiz") Question question) throws FileNotFoundException {
            Gson gson = new Gson();

            FileReader data = new FileReader("C:\\Users\\STUDENT\\Desktop\\Spring\\Project\\init\\src\\main\\resources\\quiz.json");
            Type jsonCasting = new TypeToken<List<Question>>() {
            }.getType();
            List<Question> jsonList = gson.fromJson(data, jsonCasting);
            qForm.setQuestions(jsonList);

            System.out.println(question);

            return new RedirectView("/quiz");
        }
}
