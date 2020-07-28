package com.crio.buildouts.models;

import com.crio.buildouts.dto.Question;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

// Java class that maps to Mongo collection.
@Data
@Document(collection = "questions")
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity {

  @Id
  private String id;

  @Field("moduleId")
  private String moduleId;

  @Field("questions")
  private List<Question> questions;

}

