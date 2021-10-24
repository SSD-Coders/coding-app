package com.example.init.controllers;

import com.example.init.models.Quiz;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {




    @GetMapping("/quiz")
    public String getQuiz(Model model) throws IOException {
        Gson gson = new Gson();
        String urlApi = "https://quizapi.io/api/v1/questions?apiKey=phkL2Z69NDCrImLlfnLoElQkoF3StoJlQrAeKvkf&limit=10&css";
        HttpURLConnection connection = (HttpURLConnection) new URL(urlApi).openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String data = bufferedReader.readLine();
        Type jsonCasting = new TypeToken<List<Quiz>>(){}.getType();
        List<Quiz> jsonList  = gson.fromJson(data,jsonCasting);
        model.addAttribute("quiz",jsonList);
//        model.addAttribute("answers",jsonList);
        bufferedReader.close();
        return "quiz";
    }
}
