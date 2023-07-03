package com.trinadh.quizapp.DAO;


import com.trinadh.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {
}
