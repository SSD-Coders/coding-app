package com.example.init;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class InitApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(InitApplication.class, args);

//		StringBuilder createdLine = new StringBuilder();
//		String url = "https://quizapi.io/api/v1/questions?apiKey=phkL2Z69NDCrImLlfnLoElQkoF3StoJlQrAeKvkf&limit=5&css";
//		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//
//		connection.setConnectTimeout(5000);
//		connection.setReadTimeout(5000);
//
//		InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
//		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//		String data = bufferedReader.readLine();
//		createdLine = new StringBuilder(data);
//		System.out.println(data);
//		createdLine.append(data);
//		bufferedReader.close();
//		FileWriter fileToWrite = new FileWriter("quiz.json");
//		fileToWrite.write(createdLine.toString());
//		fileToWrite.close();
	}
}
