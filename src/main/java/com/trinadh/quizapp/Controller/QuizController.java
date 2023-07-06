package com.trinadh.quizapp.Controller;

import com.trinadh.quizapp.Model.QuestionWrapper;
import com.trinadh.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
        try{
            return quizService.createQuiz(category,numQ,title);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("FailureUnableToSaveTheQuestion", HttpStatus.CONFLICT);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){

       return quizService.getQuizQuestions(id);

    }

}
