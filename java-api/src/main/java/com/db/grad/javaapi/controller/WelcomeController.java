package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WelcomeController {

  private DogHandler dogsService;

  @Autowired
  public WelcomeController(DogHandler ds)
  {
    dogsService = ds;
  }

  @GetMapping("/status")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }

  @GetMapping("/dogs")
  public List<Dog> getAllDogs() {
    return dogsService.getAllDogs();
  }

  @GetMapping("/dogs/count")
  public long getNoOfDogs() { return dogsService.getNoOfDogs(); }

  @PostMapping("/dogs")
  public Dog createDog(@Valid @RequestBody Dog dog) {
    return dogsService.addDog(dog);
  }

  @DeleteMapping("/dogs/{id}")
  public Map< String, Boolean > deleteDog(@PathVariable(value = "id") Long id)
          throws ResourceNotFoundException {
    boolean removed = dogsService.removeDog(id);

    Map < String, Boolean > response = new HashMap<>();
    if( removed )
      response.put("deleted", Boolean.TRUE);
    else
      response.put("deleted", Boolean.FALSE);

    return response;
  }

}
