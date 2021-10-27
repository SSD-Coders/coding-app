package com.example.init.controllers;

import com.example.init.models.ApplicationUser;
import com.example.init.models.QuestionForm;
import com.example.init.models.QuizDto;
import com.example.init.models.ResultsQuiz;
import com.example.init.repositories.QuestionRepo;
import com.example.init.serviceQuiz.ServiceQuiz;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.security.Principal;
import java.util.List;

@Controller
public class QuizCont {

    @Autowired
    ResultsQuiz result;
    @Autowired
    ServiceQuiz qService;
    @Autowired
    QuestionRepo questionRepo;
    Boolean submitted = false;

//    @GetMapping("/quiz/v2")
//    public String getQuiz(Model model) throws Exception {
//
////        Gson gson = new Gson();
////
////        FileReader data = new FileReader("C:\\Users\\STUDENT\\Desktop\\Spring\\Project\\init\\src\\main\\java\\com\\example\\init\\controllers\\quiz.json");
////        Type jsonCasting = new TypeToken<List<QuizDto>>() {
////        }.getType();
////        List<QuizDto> jsonList = gson.fromJson(data, jsonCasting);
////        model.addAttribute("qForm", jsonList);
////        System.out.println(jsonList);
////        System.out.println("----------------------");
////        String numbersJson = gson.toJson(jsonList);
////        System.out.println(numbersJson);
////        return "quiz2";
//    }
@ModelAttribute("result")
public ResultsQuiz getResult() {
    return result;
}
    @GetMapping("/")
    public String home() {
        return "index.html";
    }


    @PostMapping("/quiz/v2")
    public String quiz(Model m, RedirectAttributes ra) throws FileNotFoundException {
//        if(user.equals("")) {
//            ra.addFlashAttribute("warning", "You must enter your name");
//            return "redirect:/";
//        }
//
//        submitted = false;
//
//        result.setUser(user);
        QuestionForm qForm = qService.getQuestions();
//        questionRepo.save(qForm);
        m.addAttribute("qForm", qForm);
        System.out.println(qForm);
        return "quiz2.html";
    }
    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm qForm, Model m) {
        if(!submitted) {
            result.setTotalCorrect(qService.getResult(qForm));
            qService.saveScore(result);
            submitted = true;
        }



        return "resultsv2.html";
    }


    @GetMapping("/score")
    public String score(Model m) {
        List<ResultsQuiz> sList = qService.getTopScore();
        m.addAttribute("sList", sList);

        return "scoreboard.html";
    }


}
