/*
 *
 *  * Copyright (c) Crio.Do 2019. All rights reserved
 *
 */

package com.crio.buildouts.exchanges;

import com.crio.buildouts.dto.QuizQuestion;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//  Implement GetQuestionsResponse.
// Complete the class such that it produces the following JSON during serialization.
//{
//        "questions": [
//        {
//        "questionId": "001",
//        "title": "What is the default IP address of localhost?",
//        "type": "objective-single",
//        "options": {
//        "1": "0.0.0.0",
//        "2": "192.168.0.12",
//        "3": "127.0.0.1",
//        "4": "255.255.255.255"
//        }
//        },
//
//        ]
//        }
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetQuestionsResponse {
  @NotNull
  private List<QuizQuestion> questions;
}

