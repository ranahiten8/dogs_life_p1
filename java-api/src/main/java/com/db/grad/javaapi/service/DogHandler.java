package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

public class DogHandler {
    private DogsRepository itsDogsRepo;
    public DogHandler(DogsRepository repo) {
        itsDogsRepo = repo;
    }

    public long addDog(Dog theDog) {
        return itsDogsRepo.save( theDog );
    }

    public long getNoOfDogs() {
        return itsDogsRepo.count();
    }

    public Dog getDogById(long dogId){
        return itsDogsRepo.findById(dogId);
    }

    public long updateDogDetails(Dog theDog, long id) {
        theDog.setId(id);
        return theDog.getId();
    }
}
