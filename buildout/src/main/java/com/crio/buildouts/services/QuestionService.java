package com.crio.buildouts.services;

import com.crio.buildouts.exchanges.GetQuestionsResponse;
import com.crio.buildouts.exchanges.SubmitQuestionsRequest;
import com.crio.buildouts.exchanges.SubmitQuestionsResponse;

public interface QuestionService {

  /** Get all the Questions with given moduleId.
   *  @param moduleId argument
   * @return GetQuestionsResponse object containing a list of questions with given moduleId
   *     empty list if none fits the criteria.
   */
  GetQuestionsResponse getQuestions(
      String moduleId);

  SubmitQuestionsResponse submitQuestions(
      SubmitQuestionsRequest submitQuestionsRequest, String moduleId);
}
