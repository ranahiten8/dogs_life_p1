import React from "react";
import HeroDetail from "./HeroDetail";

const AllHeroes = () => {
    return (
        heroes.map(hero=>(
            <HeroDetail info={hero} key={hero.id.toString()}/>
        ))
    )
}

const heroes = 
[
{"id":1,"name":"Bruce Wayne","alias":"Batman","superpower":"Martial Arts","teamID":1},
{"id":2,"name":"Clark Kent","alias":"Superman","superpower":"Flight","teamID":1},
{"id":3,"name":"Jay Garrick","alias":"The Flash","superpower":"Super-speed","teamID":2},
{"id":4,"name":"Alan Scott","alias":"Green Lantern","superpower":"Ring Creation","teamID":2},
{"id":5,"name":"Cecil Adams","alias":"Count Vertigo","superpower":"Drug Dealing","teamID":3}
]

export default AllHeroes