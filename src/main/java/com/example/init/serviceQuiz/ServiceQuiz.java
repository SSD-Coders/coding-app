package com.example.init.serviceQuiz;

import com.example.init.models.QuestionForm;
import com.example.init.models.Quiz;
import com.example.init.models.QuizDto;
import com.example.init.models.ResultsQuiz;
import com.example.init.repositories.QuestionRepo;
import com.example.init.repositories.ResultsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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


    public QuestionForm getQuestions() {
        List<QuizDto> allQues = qRepo.findAll();
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

