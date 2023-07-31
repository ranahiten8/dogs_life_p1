package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogsRepository extends JpaRepository<Dog, Long> {
    @Query(nativeQuery = true, value = "select * from dogs")
    List<Dog> findAll();

    @Query(nativeQuery = true, value = "select * from dogs where name = :#{#dog.name}")
    List<Dog> findByName(@Param("dog") Dog dog);

    @Query(nativeQuery = true, value = "select * from dogs where dog_id = :id")
    Dog findById(long id);

    @Query(nativeQuery = true, value = "select count(dog_id) from dogs")
    long count();

    //    @Query(nativeQuery = true, value = "delete from dogs where name = :theDog")
//    boolean delete(Dog theDog);
    boolean existsById( long id );

    // Additional admin functionality
    void deleteAll();

    @Query(nativeQuery = true, value = "insert into dogs (dogs_id, name, age) " +
            "values (" +
            ":#{#dog.id}, " +
            ":#{#dog.name}, " +
            ":#{#dog.age})"
    )
    Dog save(@Param("dog") Dog theDog );

}