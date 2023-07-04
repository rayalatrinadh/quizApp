package com.trinadh.quizapp.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class Quiz {


    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam String noOfQuestions, @RequestParam String title)
    {
        return new ResponseEntity<>((" the requestParameters are : category "+ category + ", noOfQuestions : "+ noOfQuestions + " title : "+ title), HttpStatus.OK);
    }
}
