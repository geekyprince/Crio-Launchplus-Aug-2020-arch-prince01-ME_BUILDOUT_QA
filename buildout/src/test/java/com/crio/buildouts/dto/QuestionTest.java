package com.crio.buildouts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class QuestionTest {

  @Test
  public void serializeQuestionJson() throws IOException {
    final String jsonString =
        "{\n"
            + "   \"questionId\": \"001\",\n"
            + "   \"title\": \"Which of the following will not result in CompilationError?\",\n"
            + "   \"description\": \"Java question\",\n"
            + "   \"type\": \"objective-multiple\",\n"
            + "   \"options\": {\n"
            + "      \"1\": \"List a=new ArrayList<>();\",\n"
            + "      \"2\": \"List b=new Collection<>();\",\n"
            + "      \"3\": \"List c=new ArrayList();\",\n"
            + "      \"4\": \"List<? extends Object> d=new ArrayList();\"\n"
            + "   },\n"
            + "   \"correctAnswer\": [\n"
            + "      \"1\",\n"
            + "      \"3\",\n"
            + "      \"4\"\n"
            + "   ]\n"
            + "}";
    Question question = new ObjectMapper().readValue(jsonString, Question.class);
    assertEquals("001", question.getQuestionId());
  }
}