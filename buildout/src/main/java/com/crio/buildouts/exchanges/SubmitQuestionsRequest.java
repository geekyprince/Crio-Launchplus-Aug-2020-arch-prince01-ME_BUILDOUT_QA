package com.crio.buildouts.exchanges;

import com.crio.buildouts.dto.Response;

import java.util.List;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO: CRIO_TASK_MODULE_RESTAURANTSAPI
//  Implement SubmitQuestionsRequest.
//  Complete the class such that it is able to deserialize the incoming query params from
//  REST API clients.
//  For instance, if a REST client calls API
//  /qeats/v1/restaurants?latitude=28.4900591&longitude=77.536386&searchFor=tamil,
//  this class should be able to deserialize lat/long and optional searchFor from that.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitQuestionsRequest {
  @NotNull
  private List<Response> responses;
}

