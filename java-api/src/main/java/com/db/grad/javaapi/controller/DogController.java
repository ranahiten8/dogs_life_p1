package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DogController {
  private DogService dogService;

  @Autowired
  public DogController(DogService ds)
  {
    dogService = ds;
  }

  @GetMapping("/status")
  public String getWelcome() {
    return "Dogs API is up and running!";
  }
  @GetMapping("/dogs")
  public List<Dog> getAllDogs() {
    return dogService.getAllDogs();
  }
  @GetMapping("/dogs/count")
  public long getNoOfDogs() {
    return dogService.getNoOfDogs();
  }
  @GetMapping("/dogs/name/{name}")
  public Dog getDogByName(@PathVariable(value = "name") String name) {
    return dogService.getDogByName(name);
  }
  @GetMapping("/dogs/id/{id}")
  public Dog getDogById(@PathVariable(value = "id") Long id) {
    return dogService.getDogById(id);
  }


  @PostMapping("/dogs")
  public Dog createDog(@Valid @RequestBody Dog dog) {
    return dogService.addDog(dog);
  }

  @PutMapping("/dogs/{id}")
  public ResponseEntity < Dog > updateDog(@PathVariable(value = "id") Long id,
                                          @Valid @RequestBody Dog dogDetails) {
    final Dog updatedDogs = dogService.updateDogDetails(dogDetails);
    return ResponseEntity.ok(updatedDogs);
  }

  @DeleteMapping("/dogs/{id}")
  public Map <String, Boolean> deleteDog(@PathVariable(value = "id") Long id) {
    boolean removed = dogService.removeDog(id);

    Map< String, Boolean > response = new HashMap<>();
    if( removed )
      response.put("deleted", Boolean.TRUE);
    else
      response.put("deleted", Boolean.FALSE);

    return response;
  }
}
