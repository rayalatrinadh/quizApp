package com.trinadh.quizapp.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Quiz {


    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    /**
     * @author r_3na : Trinadh Rayala
     * @implNote  : Hibernate will create Relation Table in sql as questions_id
     * because in the Quiz Entity we need to get Question Entity Also to implement ManyToMany relation in between Quiz and Questions Entities Respectively
     *
     *
     */

    @ManyToMany
    private List<Question> questions;



}
