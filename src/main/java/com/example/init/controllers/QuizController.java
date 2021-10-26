package com.example.init.controllers;

import com.example.init.models.*;
import com.example.init.repositories.CodersRepository;
import com.example.init.repositories.CodersRepository;


import com.example.init.repositories.ResultRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.dom4j.rule.Mode;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {

        @Autowired
        ResultRepo resultsRepo;
        @Autowired
        CodersRepository codersRepository;

//        @GetMapping("/quiz")
//        public String getQuiz(Model model) throws IOException {
//                Gson gson = new Gson();
//                String urlApi = "https://quizapi.io/api/v1/questions?apiKey=phkL2Z69NDCrImLlfnLoElQkoF3StoJlQrAeKvkf&limit=10&css";
//                HttpURLConnection connection = (HttpURLConnection) new URL(urlApi).openConnection();
//                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
//                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                String data = bufferedReader.readLine();
//                Type jsonCasting = new TypeToken<List<Quiz>>() {
//                }.getType();
//                List<Quiz> jsonList = gson.fromJson(data, jsonCasting);
//                model.addAttribute("quiz", jsonList);
//                bufferedReader.close();
//                QuizDTO quizDTO  = new QuizDTO();
//                return "quiz";
//        }
@GetMapping("/quiz")
public String getCourses(Model model) throws Exception {

        Gson gson = new Gson();
        FileReader reader = new FileReader(
                "\\\\wsl$\\Ubuntu\\home\\jamal\\301\\401-project\\init\\src\\main\\resources\\api.json");
        Type jsonCasting = new TypeToken<List<Courses>>() {
        }.getType();
        List<Courses> jsonList = gson.fromJson(reader, jsonCasting);
        model.addAttribute("quiz", jsonList);
        return "quiz";
}

//        @PostMapping("/submit")
//        public String submit(Model model, Principal principal) {
//                ResultsQuiz resultsQuiz = new ResultsQuiz();
//                // ApplicationUser applicationUser = new ApplicationUser();
//                Quiz quiz = new Quiz();
////                 resultsQuiz.setTotalCorrect(quiz.getAnswers());
//                resultsQuiz.setUsername(codersRepository.findByUsername(principal.getName()));
//                resultsQuiz.setTotalCorrect(resultsQuiz.getTotalCorrect());
//                model.addAttribute("quiz", resultsRepo.save(resultsQuiz));
//                return "result";
//
//        }

}
