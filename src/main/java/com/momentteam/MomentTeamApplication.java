package com.momentteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan({"com.momentteam.service", "com.momentteam.model", "com.momentteam.controller"})
public class MomentTeamApplication {

  public static void main(String[] args) {
    SpringApplication.run(MomentTeamApplication.class, args);
  }

}
