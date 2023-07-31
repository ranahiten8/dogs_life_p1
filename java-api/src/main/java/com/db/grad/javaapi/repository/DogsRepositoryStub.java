package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Dog;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;


public class DogsRepositoryStub implements DogsRepository {
    private ArrayList<Dog> itsDogs = new ArrayList<>();

    private Dog addDog(Dog theDog) {
        long result = 0;
        itsDogs.add(theDog);
        result = itsDogs.size();
        theDog.setId(result);
        return theDog;
    }

    @Override
    public Dog findById(long id) {
        Dog result = null;

        for( Dog theDog: itsDogs)
            if(theDog.getId() == id ) {
                result = theDog;
                break;
            }

        return result;
    }

    @Override
    public List<Dog> findAll() {
        return null;
    }

    @Override
    public List<Dog> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Dog> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Dog> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends Dog> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Dog> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Dog> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Dog> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Dog> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Dog getOne(Long aLong) {
        return null;
    }

    @Override
    public Dog getById(Long aLong) {
        return null;
    }

    @Override
    public Dog getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Dog> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Dog> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Dog> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Dog> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Dog> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Dog> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Dog, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Dog> findByName(Dog aDog) {
        ArrayList<Dog> result = new ArrayList<>();

        for( Dog theDog: itsDogs)
            if( theDog.getName().equalsIgnoreCase(aDog.getName()) ) {
                result.add(theDog);
            }

        return result;
    }

    @Override
    public Dog save(Dog aDog) {
        Dog retrievedDog = null;
        Dog result = new Dog();

        for( Dog theDog: itsDogs)
            if( theDog.getId() == aDog.getId()) {
                retrievedDog = theDog;
                retrievedDog.setName( aDog.getName() );
                result = retrievedDog;
                break;
            }
        if( retrievedDog == null )
            result = addDog(aDog);

        return result;
    }

    @Override
    public void delete(Dog aDog) {
        boolean result = false;
        long initialSize = itsDogs.size();

        itsDogs.removeIf(dog -> dog.getId() == aDog.getId());
        result = initialSize != itsDogs.size();

//        return result;
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Dog> entities) {

    }

    @Override
    public long count()
    {
        return this.itsDogs.size();
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean existsById( long id )
    {
        boolean result = false;

        for( Dog theDog: itsDogs)
            if(theDog.getId() == id ) {
                result = true;
                break;
            }

        return result;
    }

    @Override
    public void deleteAll()
    {
        itsDogs.clear();
    }

}
