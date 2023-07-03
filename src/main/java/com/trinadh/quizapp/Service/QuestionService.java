package com.trinadh.quizapp.Service;


import com.trinadh.quizapp.DAO.QuestionDAO;
import com.trinadh.quizapp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDAO questionDAO;

    public   List<Question> questionService() throws SQLException {
         return questionDAO.questionDetailsFetch();
    }

}
