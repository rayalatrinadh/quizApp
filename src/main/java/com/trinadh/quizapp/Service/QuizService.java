package com.trinadh.quizapp.Service;


import com.trinadh.quizapp.DAO.QuestionDAO;
import com.trinadh.quizapp.DAO.QuizDAO;
import com.trinadh.quizapp.Model.Question;
import com.trinadh.quizapp.Model.QuestionWrapper;
import com.trinadh.quizapp.Model.Quiz;
import com.trinadh.quizapp.Model.SubmitQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDao;

    @Autowired
    QuestionDAO questionDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

         Optional<Quiz> quiz = quizDao.findById(id);

        List<QuestionWrapper> questionUser = new ArrayList<>();

         List<Question> questionsFromDB = quiz.get().getQuestions();

         for(Question question : questionsFromDB){
             QuestionWrapper qw = new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
             questionUser.add(qw);
         }

         return new ResponseEntity<>(questionUser,HttpStatus.OK);


    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<SubmitQuestion> submitQuestions) {
        int score = 0;

      Quiz quiz = quizDao.findById(id).get();
      List<Question> questions = quiz.getQuestions();
       Question chk =null;
       int i  = 0;
        for(SubmitQuestion submitQuestion : submitQuestions) {
            for(Question que: questions){
                 if(que.getId().equals(submitQuestion.getId())){
                    chk = que;
                    break;
                 }else
                     continue;
            }
          score =   chk.getRightAnswer().equals(submitQuestion.getResponse())? score+1: score;


        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
