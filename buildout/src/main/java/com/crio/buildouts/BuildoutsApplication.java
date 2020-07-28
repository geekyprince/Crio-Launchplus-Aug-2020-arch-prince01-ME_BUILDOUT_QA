package com.crio.buildouts;

//import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

//@Slf4j
@SpringBootApplication
public class BuildoutsApplication {

  public static void main(String[] args) {
    SpringApplication.run(BuildoutsApplication.class, args);
  }

  /**
   * Fetches a ModelMapper instance.
   *
   * @return ModelMapper
   */
  @Bean // Want a new obj every time
  @Scope("prototype")
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
