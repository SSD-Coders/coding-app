package com.example.init.controllers;

import com.example.init.models.ApplicationUser;
import com.example.init.models.Quiz;
import com.example.init.models.ResultsQuiz;
import com.example.init.repositories.ApplicationUserRepository;
import com.example.init.repositories.CodersRepository;
import com.example.init.repositories.ResultsRepo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.dom4j.rule.Mode;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {

        @Autowired
        ResultsRepo resultsRepo;
        @Autowired
        CodersRepository codersRepository;

        @GetMapping("/quiz")
        public String getQuiz(Model model) throws IOException {
                Gson gson = new Gson();
                String urlApi = "https://quizapi.io/api/v1/questions?apiKey=phkL2Z69NDCrImLlfnLoElQkoF3StoJlQrAeKvkf&limit=10&css";
                HttpURLConnection connection = (HttpURLConnection) new URL(urlApi).openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String data = bufferedReader.readLine();
                Type jsonCasting = new TypeToken<List<Quiz>>() {
                }.getType();
                List<Quiz> jsonList = gson.fromJson(data, jsonCasting);
                model.addAttribute("quiz", jsonList);
                bufferedReader.close();
                return "quiz";
        }

        @PostMapping("/submit")
        public String submit(Model model, Principal principal) {
                ResultsQuiz resultsQuiz = new ResultsQuiz();
                // ApplicationUser applicationUser = new ApplicationUser();
                Quiz quiz = new Quiz();
                // resultsQuiz.setTotalCorrect(quiz.getAnswers());
                resultsQuiz.setUsername(codersRepository.findByUsername(principal.getName()));
                resultsQuiz.setTotalCorrect(resultsQuiz.getTotalCorrect());
                model.addAttribute("quiz", resultsRepo.save(resultsQuiz));
                return "result";

        }

}
