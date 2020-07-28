package com.crio.buildouts.controller;

import com.crio.buildouts.exchanges.GetQuestionsResponse;

import com.crio.buildouts.exchanges.SubmitQuestionsRequest;
import com.crio.buildouts.exchanges.SubmitQuestionsResponse;
import com.crio.buildouts.services.QuestionService;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequestMapping(QuestionController.QUESTION_API_ENDPOINT)
@RestController
public class QuestionController {

  public static final String QUESTION_API_ENDPOINT = "/quiz";
  public static final String QUESTIONS_API = "/{moduleId}";

  @Autowired
  private QuestionService questionService;

  @PutMapping("/{moduleId}")
  public ResponseEntity<HttpStatus> putQuestions(@PathVariable("moduleId") String moduleId) {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping(QUESTIONS_API)
  public ResponseEntity<GetQuestionsResponse> getQuestions(
      @PathVariable String moduleId) {

    GetQuestionsResponse getQuestionsResponse = questionService.getQuestions(moduleId);
    return ResponseEntity.ok().body(getQuestionsResponse);
  }

  @PostMapping(QUESTIONS_API)
  public ResponseEntity<SubmitQuestionsResponse> submitQuestions(
      @RequestBody SubmitQuestionsRequest submitQuestionsRequest, @PathVariable String moduleId) {

    SubmitQuestionsResponse submitQuestionsResponse;

    //CHECKSTYLE:OFF
    submitQuestionsResponse = questionService
        .submitQuestions(submitQuestionsRequest, moduleId);
    log.info("getQuestions returned {}", submitQuestionsResponse);
    //CHECKSTYLE:ON

    return ResponseEntity.ok().body(submitQuestionsResponse);
  }
}

