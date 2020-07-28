package com.crio.buildouts.services;

import com.crio.buildouts.dto.QuizQuestion;
import com.crio.buildouts.dto.Response;
import com.crio.buildouts.exchanges.GetQuestionsResponse;
import com.crio.buildouts.exchanges.SubmitQuestionsRequest;
import com.crio.buildouts.exchanges.SubmitQuestionsResponse;
import com.crio.buildouts.repositoryservices.QuestionRepositoryService;

import java.util.HashMap;
import java.util.List;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class QuestionServiceImpl implements QuestionService {

  @Autowired
  private QuestionRepositoryService questionRepositoryService;

  // Check QuestionService.java file for the interface contract.
  @Override
  public GetQuestionsResponse getQuestions(
      String moduleId) {
    List<QuizQuestion> questionList = questionRepositoryService.getQuestions(moduleId);

    return new GetQuestionsResponse(questionList);
  }

  @Override
  public SubmitQuestionsResponse submitQuestions(
      SubmitQuestionsRequest submitQuestionsRequest, String moduleId) {
    List<Response> listOfResponses = submitQuestionsRequest.getResponses();
    HashMap<String,List<String>> responseHash = new HashMap<>();
    for (Response response : listOfResponses) {
      responseHash.put(response.getQuestionId(), response.getUserResponse());
    }
    SubmitQuestionsResponse submitQuestionsResponse;
    submitQuestionsResponse = questionRepositoryService.submitQuestions(
        responseHash, moduleId);

    return submitQuestionsResponse;
  }
}

