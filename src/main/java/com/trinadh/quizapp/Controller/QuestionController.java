package com.trinadh.quizapp.Controller;

import com.trinadh.quizapp.Question;
import com.trinadh.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() throws SQLException {
        return questionService.questionService();
    }


    @GetMapping("category/{categoryType}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String categoryType){
            return questionService.getAllQuestionsByCategory(categoryType);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        System.out.println(" get question from client is : " + question);
            return questionService.addQuestion(question);
    }
}
