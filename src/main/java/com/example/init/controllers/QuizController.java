package com.example.init.controllers;

import com.example.init.models.Quiz;
import com.example.init.models.QuizDTO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.json.simple.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
public class QuizController {




    @GetMapping("/quiz")
    public String getQuiz(Model model) throws IOException, ParseException {
        Gson gson = new Gson();
        String urlApi = "https://quizapi.io/api/v1/questions?apiKey=phkL2Z69NDCrImLlfnLoElQkoF3StoJlQrAeKvkf&limit=10&css";
        HttpURLConnection connection = (HttpURLConnection) new URL(urlApi).openConnection();
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String data = bufferedReader.readLine();
        String data = bufferedReader.readLine();
        Type jsonCasting = new TypeToken<List<Quiz>>(){}.getType();
        List<Quiz> jsonList  = gson.fromJson(data,jsonCasting);
        List<QuizDTO> fromJson  = gson.fromJson(data,jsonCasting);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("answers" , data);
        model.addAttribute("answers" , jsonObject);

//        List<Quiz> jsonMap  = Arrays.asList(gson.fromJson(data,Quiz[].class));


//        JSONParser jsonParser = new JSONParser();
//        Object ob  = jsonParser.parse(data);
//        JSONObject jsonObject = (JSONObject) ob{0};
//        String answers = (String) jsonObject.get("answers");
//
//
//        List<QuizDTO> jsonAnswers  = Arrays.asList(gson.fromJson(answers,QuizDTO[].class));

        model.addAttribute("quiz",jsonList);
        System.out.println(jsonList.toString());
        QuizDTO quizDTO = new QuizDTO();
//        System.out.println(data+" "+ jsonMap);
//        List<QuizDTO> jsonMap  = Arrays.asList(gson.fromJson(data,QuizDTO[].class));
//        JSONObject jsonObject = new JSONObject();
//
//        Map ans = new LinkedHashMap(6);
//        ans.put("answer_a",quizDTO.getAnswer_a());
//        ans.put("answer_b",quizDTO.getAnswer_b());
//        ans.put("answer_c",quizDTO.getAnswer_c());
//        ans.put("answer_d",quizDTO.getAnswer_d());
//        ans.put("answer_e",quizDTO.getAnswer_e());
//        ans.put("answer_f",quizDTO.getAnswer_f());
//        jsonObject.toJSONString(jsonList)
//        jsonObject.put("answers",ans);
//        model.addAttribute("answers",jsonAnswers);
        bufferedReader.close();
        return "quiz";
    }
//    @GetMapping("/quizAns")
//    public String fetchAns(Model model){
//        QuizDTO quizDTO = new QuizDTO();
//        JsonObject jsonObject = new JsonObject();
//        Map ans = new LinkedHashMap(6);
//        ans.put("answer_a",quizDTO.getAnswer_a());
//        ans.put("answer_b",quizDTO.getAnswer_b());
//        ans.put("answer_c",quizDTO.getAnswer_c());
//        ans.put("answer_d",quizDTO.getAnswer_d());
//        ans.put("answer_e",quizDTO.getAnswer_e());
//        ans.put("answer_f",quizDTO.getAnswer_f());
//        jsonObject.add("answers", (JsonElement) ans);
//        model.addAttribute("answers",jsonObject);
//        return "quiz";
//
//    }


}
