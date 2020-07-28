package com.crio.buildouts.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class SummaryTest {
  @Test
  public void serializeQuestionsJson() throws IOException {
    final String jsonString =
        "{\n"
            + "   \"score\": 2,\n"
            + "   \"total\": 3\n"
            + "}";
    Summary summary = new ObjectMapper().readValue(jsonString, Summary.class);
    assertEquals(2,summary.getScore());
  }
}