package com.trinadh.quizapp.Service;


import com.trinadh.quizapp.DAO.QuestionDAO;
import com.trinadh.quizapp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> questionService()  {
        try{
            return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }

        //if exception occurs need to send bad Request
        return new ResponseEntity<>(new ArrayList(),HttpStatus.BAD_REQUEST);

    }


    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String categoryType) {
        try{
            return new ResponseEntity<>(questionDAO.findByCategory(categoryType),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
            questionDAO.save(question);
            //HttpStatus.CREATED -> because the question created in the database .
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
            return new ResponseEntity<>("failure",HttpStatus.NOT_ACCEPTABLE);
    }


}
