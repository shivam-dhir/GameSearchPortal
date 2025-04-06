package com.shivam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shivam.model.Game;

public interface GameRepository extends MongoRepository <Game, Integer>{

}
