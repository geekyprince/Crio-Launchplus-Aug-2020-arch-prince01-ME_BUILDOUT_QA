package com.crio.buildouts.repositoryservices;

import com.crio.buildouts.dto.Question;
import com.crio.buildouts.dto.Questions;
import com.crio.buildouts.dto.QuizQuestion;
import com.crio.buildouts.dto.Summary;
import com.crio.buildouts.exchanges.SubmitQuestionsResponse;
import com.crio.buildouts.models.QuestionEntity;
import com.crio.buildouts.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Provider;

import lombok.extern.log4j.Log4j2;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@Primary
public class QuestionRepositoryServiceImpl implements QuestionRepositoryService {

  @Autowired
  private QuestionRepository questionRepository;

  @Autowired
  private QuestionRepositoryService questionRepositoryService;

  public List<Question> getQuestionsByModuleId(String moduleId) {
    List<Question> questionList = new ArrayList<>();
    List<QuestionEntity> questionsModuleId = questionRepository.findByModuleId(moduleId);
    for (QuestionEntity questionEntity : questionsModuleId) {
      questionList.addAll(questionEntity.getQuestions());
    }

    return questionList;
  }

  @Override
  public List<QuizQuestion> getQuestions(String moduleId) {

    List<QuizQuestion> questions = new ArrayList<>();
    List<Question> questionList = getQuestionsByModuleId(moduleId);

    log.info(questionList);

    for (Question question : questionList) {
      QuizQuestion quizQuestion = QuizQuestion.builder()
          .questionId(question.getQuestionId())
          .title(question.getTitle())
          .type(question.getType())
          .options(question.getOptions())
          .build();
      questions.add(quizQuestion);
    }

    System.out.println(questions.size());

    return questions;
  }

  @Override
  public SubmitQuestionsResponse submitQuestions(HashMap responseHash, String moduleId) {

    List<Questions> questionList = new ArrayList<>();
    List<Question> questionsByModuleId = getQuestionsByModuleId(moduleId);

    log.info(questionList);

    int score = 0;
    for (Question question : questionsByModuleId) {
      if (responseHash.containsKey(question.getQuestionId())) {
        List<String> userAnswer = (List<String>) responseHash.get(question.getQuestionId());

        Questions questions = Questions.builder()
            .questionId(question.getQuestionId())
            .title(question.getTitle())
            .description(question.getDescription())
            .type(question.getType())
            .options(question.getOptions())
            .userAnswer(userAnswer)
            .correct(question.getCorrectAnswer())
            .answerCorrect(question.getCorrectAnswer().equals(userAnswer))
            .build();
        if (questions.isAnswerCorrect()) {
          score++;
        }
        questionList.add(questions);
      }
    }
    System.out.println("QuestinRepositoryIMpl");
    System.out.println(questionsByModuleId);
    int total = responseHash.size();
    Summary summary = new Summary(score, total);
    return new SubmitQuestionsResponse(questionList, summary);
  }


}

