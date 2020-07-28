package com.crio.buildouts.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: CRIO_TASK_MODULE_SERIALIZATION
//  Implement Question class.
// Complete the class such that it produces the following JSON during serialization.
//{
//    "score": 2,
//    "total": 3
//  }

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
  @NotNull
  private int score;

  @NotNull
  private int total;

}
