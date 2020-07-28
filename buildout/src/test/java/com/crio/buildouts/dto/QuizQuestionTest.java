package com.crio.buildouts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.crio.buildouts.repositories.QuestionRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

class QuizQuestionTest {

  @Autowired
  MongoTemplate mongoTemplate;

  @Autowired
  QuestionRepository questionRepository;

  @Test
  public void serializeQuizQuestionJson() throws IOException {
    final String jsonString =
        "{\n"
            + "   \"questionId\": \"001\",\n"
            + "   \"title\": \"Which of the following will not result in CompilationError?\",\n"
            + "   \"type\": \"objective-multiple\",\n"
            + "   \"options\": {\n"
            + "      \"1\": \"List a=new ArrayList<>();\",\n"
            + "      \"2\": \"List b=new Collection<>();\",\n"
            + "      \"3\": \"List c=new ArrayList();\",\n"
            + "      \"4\": \"List<? extends Object> d=new ArrayList();\"\n"
            + "   }\n"
            + "}";

    // Setting up a restaurant object for testing. The following ensures that restaurant
    // object can deserialize the right restaurant json.
    QuizQuestion question = new ObjectMapper().readValue(jsonString, QuizQuestion.class);

    // Deserialize the Json string from MongoQuestion class to ensure its done cleanly.
    assertEquals("001", question.getQuestionId());
  }


}