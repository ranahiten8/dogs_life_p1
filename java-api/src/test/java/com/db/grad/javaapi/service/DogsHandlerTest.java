package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DogsHandlerTest {

    private DogsRepository itsDogRepo = new DogsRepositoryStub();
    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }
    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {
        //arrange
        DogHandler cut = new DogHandler( itsDogRepo );
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);

        int expectedResult = 1;

        //act
        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_several_dogs_return_number_of_dogs_match_number_added() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        cut.addDog(dog1);
        cut.addDog(dog2);
        cut.addDog(dog3);

        int expectedResult =3;
        long actualResult = cut.getNoOfDogs();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void delete_dog() {
        //arrange
        Dog dogToRemove = new Dog();
        dogToRemove.setId(1); dogToRemove.setName("Frank");
        DogsRepositoryStub cut = new DogsRepositoryStub();
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.save( theDog );
        theDog = new Dog();
        theDog.setName("Penny");
        cut.save( theDog );

        //act
        cut.delete(dogToRemove);
        Dog actualDog = cut.findById(1);

        // assert
        assertNull( actualDog );

    }

    @Test
    public void get_dog_by_id_valid()
    {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        cut.addDog(theDog);

        theDog = new Dog();
        long uniqueId = cut.addDog( theDog );
        Dog expectedDog = theDog;
        theDog = new Dog();

        cut.addDog( theDog );
        Dog actualResult = cut.getDogById( uniqueId );
        assertEquals( expectedDog.getId(), actualResult.getId() );
    }
}
