package com.example.init.repositories;

import com.example.init.models.ResultsQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepo extends JpaRepository<ResultsQuiz , Integer> {
}
