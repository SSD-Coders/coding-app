package com.example.init.models;

import javax.persistence.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//
@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    // public int course_id;
    public String title;
    public String course_level;
    public String description;
    public String image;
    public String courseLink;

    public Courses() throws Exception {

    }

    public Courses(String title, String course_level, String description, String image, String courseLink)
            throws Exception {
        this.title = title;
        this.course_level = course_level;
        this.description = description;
        this.image = image;
        this.courseLink = courseLink;
    }

    // this is reader json file --------------------------
    public static ArrayList<Courses> readJsonFile(FileReader jsonFile) {
        // create Gson instance
        Gson gson = new Gson();

        // create a reader
        BufferedReader reader = new BufferedReader(jsonFile);

        // convert JSON array to list of users
        ArrayList<Courses> courses = gson.fromJson(reader, new TypeToken<ArrayList<Courses>>() {
        }.getType());

        System.out.println(courses);
        return courses;
    }

    // ------------------------------------ this is the End

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse_level() {
        return course_level;
    }

    public void setCourse_level(String course_level) {
        this.course_level = course_level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCourseLink() {
        return courseLink;
    }

    public void setCourseLink(String courseLink) {
        this.courseLink = courseLink;
    }

    @Override
    public String toString() {
        return "Courses{" + "title='" + title + '\'' + ", description='" + description + '\'' + ", image='" + image
                + '\'' + ", courseLink='" + courseLink + '\'' + '}';
    }
}