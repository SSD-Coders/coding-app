package com.example.init.repositories;

import com.example.init.models.QuizDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<QuizDto, Integer> {

}