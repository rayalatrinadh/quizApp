package com.trinadh.quizapp.Model;


import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class SubmitQuestion {

    private Integer id;
    private String response;
}
