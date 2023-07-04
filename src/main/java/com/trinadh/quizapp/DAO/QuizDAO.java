package com.trinadh.quizapp.DAO;



import com.trinadh.quizapp.Model.Quiz;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAO extends JpaRepository<Quiz,Integer> {


}
