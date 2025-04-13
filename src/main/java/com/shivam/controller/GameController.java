package com.shivam.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.model.Game; 
import com.shivam.repository.GameRepository;
import com.shivam.repository.MongoRepository;

//@RestController -> API, only returns data, not view
@RestController 
@RequestMapping("api")
public class GameController {

    @Autowired  
    GameRepository gamerepo;

    @Autowired
    MongoRepository mongorepo;

    @RequestMapping(value = "/")
    public String redirect(){
        return "hello";
    }

    // To use @RequestBody, you annotate a method parameter in your controller with it. 
    // When a request is made to the endpoint, Spring Boot will read the request body and attempt to convert it to the specified 
    // type of the annotated parameter. If the conversion is successful, the method will be invoked with the populated object. 
    // If the conversion fails, a HttpMessageNotReadableException will be thrown
    @PostMapping(value = "/addGame")
    public Game add(@RequestBody Game game){
        return gamerepo.save(game); 
    }

    @GetMapping(value="/games")
    public List<Game> games(ModelMap mm){
        return gamerepo.findAll();
    }

    @GetMapping(value="/game/{query}")
    public List<Game> getGame(@PathVariable String query){
        return mongorepo.searchGame(query);
    }

}
