package com.crio.buildouts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ResponseTest {

  @Test
  public void serializeQuestionsJson() throws IOException {
    final String jsonString =
        "{\n"
            + "   \"questionId\": \"001\",\n"
            + "   \"userResponse\": [\n"
            + "      \"1\"\n"
            + "   ]\n"
            + "}";
    Response response = new ObjectMapper().readValue(jsonString, Response.class);
    assertEquals("001", response.getQuestionId());
  }
}