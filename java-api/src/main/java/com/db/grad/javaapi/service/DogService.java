package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DogService {
    private DogsRepository itsDogsRepo;
    @Autowired
    public DogService(){}

    public Dog addDog(Dog theDog) {
        itsDogsRepo.save( theDog );
        return theDog;
    }

    public long getNoOfDogs() {
        itsDogsRepo.count();
        return 1;
    }

    public boolean removeDog(long uniqueId)
    {
        boolean result = false;

        Dog theDog = itsDogsRepo.findById(uniqueId);
        if(theDog != null)
        {
            result = itsDogsRepo.delete(theDog);
        }

        return  result;
    }

    public Dog getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId);
    }

    public Dog getDogByName(String dogsName )
    {
        Dog dogToFind = new Dog();
        dogToFind.setName(dogsName);
        List<Dog> dogs = itsDogsRepo.findByName(dogToFind);
        Dog result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }

    public Dog updateDogDetails(Dog dogToUpdate)
    {
        return dogToUpdate; //itsDogsRepo.save( dogToUpdate ); TODO (was returning long before)
    }
}
