package com.crio.buildouts.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Response class.
// Complete the class such that it produces the following JSON during serialization.
//{
//        "responses": [
//        {
//        "questionId": "001",
//        "userResponse": ["1"]
//        },
//        {
//        "questionId": "002",
//        "userResponse": ["1", "3", "4"]
//        },
//        {
//        "questionId": "003",
//        "userResponse": ["throwable"]
//        }
//        ]
//        }

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
  @NotNull
  private String questionId;

  private List<String> userResponse = new ArrayList<>();
}
