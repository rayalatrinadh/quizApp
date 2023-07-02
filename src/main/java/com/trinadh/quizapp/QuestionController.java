package com.trinadh.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {


    @GetMapping("allQuestions")
    public String getAllQuestions(){

        System.out.println("changes in July7thBranch");
        return "hello Trinadh Rayala";
    }
}
