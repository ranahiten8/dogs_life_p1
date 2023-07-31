package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

  private DogService dogService;
  private String aDog;

  private int aId;
  @GetMapping("/")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }

  @GetMapping("/getalldogs")
  public List<Dog> getalldogs(){
    return dogService.getAllDogs();
  }

  @GetMapping("/getnumberofdogs")
  public long getnumberofdogs()
  {
    return dogService.getNoOfDogs();
  }

  @GetMapping("/getdogbyname")
  public Dog getdogbyname()
  {
    return dogService.getDogByName(aDog);
  }

  @GetMapping("/getdogbyid")
  public Dog getdogbyid()
  {
    return dogService.getDogById(aId);
  }
}
