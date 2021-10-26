package com.example.init.serviceQuiz;

import com.example.init.models.QuestionForm;
import com.example.init.models.Quiz;
import com.example.init.models.QuizDto;
import com.example.init.models.ResultsQuiz;
import com.example.init.repositories.QuestionRepo;
import com.example.init.repositories.ResultsRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ServiceQuiz {

    @Autowired
    QuizDto quizDto;

    @Autowired
    QuestionForm qForm;
    @Autowired
    QuestionRepo qRepo;
    @Autowired
    ResultsQuiz resultsQuiz;
    @Autowired
    ResultsRepo rRepo;


    public QuestionForm getQuestions() throws FileNotFoundException {
//        List<QuizDto> allQues = qRepo.findAll();
        Gson gson = new Gson();

        FileReader data = new FileReader("C:\\Users\\STUDENT\\Desktop\\Spring\\Project\\init\\src\\main\\java\\com\\example\\init\\controllers\\quiz.json");
        Type jsonCasting = new TypeToken<List<QuizDto>>() {
        }.getType();
        List<QuizDto> allQues = gson.fromJson(data, jsonCasting);
        System.out.println(allQues);
        System.out.println("----------------------");
        String numbersJson = gson.toJson(allQues);
        System.out.println(numbersJson);
        List<QuizDto> qList = new ArrayList<QuizDto>();

        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int rand = random.nextInt(allQues.size());
            qList.add(allQues.get(rand));
            allQues.remove(rand);
        }

        qForm.setQuestions(qList);
        return qForm;
    }
        public int getResult(QuestionForm qForm) {
        int correct = 0 ;
        for (QuizDto q: qForm.getQuestions())
                if (q.getQuesId() == q.getChose())
                correct++;

            return correct;
        }
    public void saveScore(ResultsQuiz result) {
        ResultsQuiz saveResult = new ResultsQuiz();
        saveResult.setUsername(result.getUsername());
        saveResult.setTotalCorrect(result.getTotalCorrect());
        rRepo.save(saveResult);
    }
    public List<ResultsQuiz> getTopScore() {
        List<ResultsQuiz> sList = rRepo.findAll(Sort.by(Sort.Direction.DESC, "totalCorrect"));

        return sList;
    }
}

