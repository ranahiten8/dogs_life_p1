package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService implements IDogsService
{
    private DogsRepository itsDogsRepo;

    @Autowired
    public DogService( DogsRepository dogRepo )
    {
        itsDogsRepo = dogRepo;
    }

    @Override
    public List<Dog> getAllDogs()
    {
        return itsDogsRepo.findAll();
    }

    @Override
    public Dog addDog(Dog theDog)
    {
        return itsDogsRepo.save( theDog );
    }

    @Override
    public long getNoOfDogs()
    {
        return itsDogsRepo.count();
    }

    @Override
    public boolean removeDog(long uniqueId)
    {
        boolean result = false;

        Optional<Dog> theDog = Optional.ofNullable(itsDogsRepo.findById(uniqueId));
        if(theDog.isPresent())
        {
            itsDogsRepo.delete(theDog.get());
            result = true;
        }

        return  result;
    }

    @Override
    public Dog getDogById(long uniqueId)
    {
        return itsDogsRepo.findById(uniqueId);
    }

    @Override
    public Dog getDogByName(String dogsName)
    {
        Dog dogToFind = new Dog();
        dogToFind.setName(dogsName);
        List<Dog> dogs = itsDogsRepo.findByName(dogToFind);
        Dog result = null;

        if( dogs.size() == 1)
            result = dogs.get(0);

        return result;
    }

    @Override
    public Dog updateDogDetails(Dog dogToUpdate)
    {
        return itsDogsRepo.save( dogToUpdate );
    }
}