package com.crio.buildouts.repositoryservices;

import com.crio.buildouts.dto.QuizQuestion;
import com.crio.buildouts.exchanges.SubmitQuestionsResponse;

import java.util.HashMap;
import java.util.List;

public interface QuestionRepositoryService {
  /**Get all the Questions with given moduleId.
   * @param moduleId argument
   * @return list of questions with given moduleId
   *     empty list if there is none
   */
  List<QuizQuestion> getQuestions(String moduleId);

  SubmitQuestionsResponse submitQuestions(
      HashMap responseHash, String moduleId);
}


