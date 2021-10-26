package com.example.init.controllers;

import com.example.init.models.Courses;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

@Controller
public class CourseController {

        @GetMapping("/courses")
        public String getCourses(Model model) throws Exception {

                Gson gson = new Gson();
                JsonReader reader = new JsonReader(new FileReader(
                                "json.json"));
                Type jsonCasting = new TypeToken<List<Courses>>() {
                }.getType();
                List<Courses> jsonList = gson.fromJson(reader, jsonCasting);
                model.addAttribute("courses", jsonList);
                return "courses";
        }
}
