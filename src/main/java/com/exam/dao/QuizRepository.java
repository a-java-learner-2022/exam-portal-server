package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.exam.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
