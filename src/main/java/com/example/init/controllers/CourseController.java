package com.example.init.controllers;

import com.example.init.models.Courses;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Controller
public class CourseController {


//    @Autowired
//    CourseRepository courseRepository;


    @GetMapping("/courses")
    public String getCourses(Model model) throws Exception {

        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new FileReader("C:\\Users\\STUDENT\\java401\\SSD-Projects\\init\\src\\main\\resources\\json.json"));
//            ArrayList<Courses> courses= readJsonFile(courseFile);
        Type jsonCasting = new TypeToken<List<Courses>>() {
        }.getType();
        List<Courses> jsonList = gson.fromJson(reader, jsonCasting);
//        Courses courses = new Courses();
//        courses.setTitle("hello from ");
        model.addAttribute("courses" ,jsonList);
//        courseRepository.save(courses);
        return "courses";
    }







//        System.out.println("-------------------------------hello-----------------------------------------------------------------------");
////            System.out.println(Courses.readJsonFile(courseFile));
//        System.out.println("--------------------------------after hello ----------------------------------------------------------------------");
//        System.out.println(jsonList.toString());


}
