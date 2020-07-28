package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Question class.
// Complete the class such that it produces the following JSON during serialization.
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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Questions {
  private String questionId;

  private String title;

  private String description;

  private String type;

  private Map<String,String> options;

  private List<String> userAnswer;

  private List<String> correct;

  private String explanation;

  private boolean answerCorrect;

}
