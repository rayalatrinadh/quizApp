package com.trinadh.quizapp.Controller;

import com.trinadh.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @Autowired
    QuestionController questionController;

    /**
     * @apiNote : http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz
     *
     * @param category
     * @param numQ
     * @param title
     * @return
     */

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title)
    {
        return quizService.createQuiz(category,numQ,title);
    }
}
