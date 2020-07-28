package com.crio.buildouts.dto;

import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Test;

//{
//    "questionId": "001",
//    "title": "What is the default IP address of localhost?",
//    "description": "General question",
//    "type": "objective-single",
//    "options": {
//    "1": "0.0.0.0",
//    "2": "192.168.0.12",
//    "3": "127.0.0.1",
//    "4": "255.255.255.255"
//    },
//    "userAnswer": [
//    "1"
//    ],
//    "correct": [
//    "4"
//    ],
//    "explanation": null,
//    "answerCorrect": false
//    }

class QuestionsTest {
  @Test
  public void serializeQuestionsJson() throws IOException {
    final String jsonString =
        "{\n"
            + "   \"questionId\": \"001\",\n"
            + "   \"title\": \"What is the default IP address of localhost?\",\n"
            + "   \"description\": \"General question\",\n"
            + "   \"type\": \"objective-single\",\n"
            + "   \"options\": {\n"
            + "      \"1\": \"0.0.0.0\",\n"
            + "      \"2\": \"192.168.0.12\",\n"
            + "      \"3\": \"127.0.0.1\",\n"
            + "      \"4\": \"255.255.255.255\"\n"
            + "   },\n"
            + "   \"userAnswer\": [\n"
            + "      \"1\"\n"
            + "   ],\n"
            + "   \"correct\": [\n"
            + "      \"4\"\n"
            + "   ],\n"
            + "   \"answerCorrect\": \"false\"\n"
            + "}";
    Questions question = new ObjectMapper().readValue(jsonString, Questions.class);
    assertNull(question.getExplanation());
  }

}