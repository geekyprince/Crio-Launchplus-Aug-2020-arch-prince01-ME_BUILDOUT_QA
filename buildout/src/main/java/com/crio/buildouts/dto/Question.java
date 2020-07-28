
package com.crio.buildouts.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;

import java.util.Map;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Question class.
// Complete the class such that it produces the following JSON during serialization.
////{
//    "questionId": "001",
//    "title": "Which of the following will not result in CompilationError?",
//    "description": "Java question",
//    "type": "objective-multiple",
//    "options": {
//      "1": "List a=new ArrayList<>();",
//      "2": "List b=new Collection<>();",
//      "3": "List c=new ArrayList();",
//      "4": "List<? extends Object> d=new ArrayList();"
//    },
//    "correctAnswer": [
//      "1",
//      "3",
//      "4"
//    ]
//         }
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

  private String questionId;

  private String title;

  private String description;

  private String type;

  private Map<String,String> options;

  private List<String> correctAnswer;

}
