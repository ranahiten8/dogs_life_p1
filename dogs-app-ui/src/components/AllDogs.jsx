import {React, useState, useEffect} from 'react'
import DogCard from './DogCard'
import { getAllDogs, getNoOfDogs, deleteDog } from '../services/dog-service';

const AllDogs = () => {
    const [dogs, setDogs] = useState([]);
    const getDogsFromAPI = ()=>{
        getAllDogs()
        .then(res => {
            setDogs(res.data);
        })
        .catch(err => {
            setDogs([]);
            console.log(err);
        })
    }

    const [dogsCount, setDogsCount] = useState([]);
    const getNoOfDogsFromAPI = () => {
        getNoOfDogs()
        .then(res => {
            setDogsCount(res.data);
        })
        .catch(err => {
            setDogsCount([]);
            console.log(err);
        })
    }
    useEffect(()=>{
        getDogsFromAPI();
        getNoOfDogsFromAPI();}, 
        []
    );

    const deleteDogFromAPI = (dogId) => {
        deleteDog(dogId);
    }
    
  return (
    <>
        <div>
            Total number of dogs: {dogsCount}
        </div>
        {dogs.map(dog=>(
            <DogCard info={dog} key={dog.id.toString()} deleteFunction={deleteDogFromAPI} />
        ))}
    </>
  )
}

export default AllDogs