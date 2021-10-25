package com.example.init.serviceQuiz;

import com.example.init.models.Quiz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServiceQuiz {

    public List <Quiz> getQustion() {

        List<Quiz> allQues = new ArrayList<Quiz>();
        return allQues;
    }

public int counter = 0;

    public int getAnswersTest(Quiz quiz) {

            int correct = 0;

            for(Quiz q: getQustion()) {
                if (q.correct_answer == q.answers.answer_a){
                    correct++;
                }else if (q.correct_answer == q.answers.answer_b) {
                    correct++;
                }else if (q.correct_answer == q.answers.answer_c) {
                    correct++;
                }else if (q.correct_answer == q.answers.answer_d) {
                    correct++;
                }else if (q.correct_answer == q.answers.answer_e) {
                    correct++;
                }else if (q.correct_answer == q.answers.answer_f) {
                    correct++;
                }
                return correct;
            }



            return correct;
        }


}
