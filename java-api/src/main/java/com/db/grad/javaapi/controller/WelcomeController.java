package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

  @Autowired
  DogService DogService;

  @GetMapping("/getNoOfDogs")
  public List<Dog> getNoOfDogs {
    return com.db.grad.javaapi.service.DogService.getNoOfDogs();
  }

  @GetMapping("/")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }

}
