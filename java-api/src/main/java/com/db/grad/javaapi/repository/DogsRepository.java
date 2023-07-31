package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DogsRepository extends JpaRepository<Dog,Long> {
    long save( Dog theDog );
    //@Query(nativeQuery = true, value = "select dog_id from dogs where dog_id = :id")
    Dog  findById( long id );
    @Query(nativeQuery = true, value = "select * from dogs where name = :name")
    List<Dog> findByName(Dog name);

    boolean delete(Dog theDog );

    //@Query(nativeQuery = true, value = "select count(dog_id) from dogs")
    long count();

    //@Query(nativeQuery = true, value = "select from dogs where dog_id = :id")
    boolean existsById( long id );

    // Additional admin functionality
    void    deleteAll();
}