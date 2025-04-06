package com.shivam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.model.Game;
import com.shivam.repository.GameRepository;

@RestController
@RequestMapping("api")
public class GameController {

    @Autowired  
    GameRepository gamerepo;

    @RequestMapping(value = "/hello")
    public String redirect(){
        return "hello";
    }

    @GetMapping(value="/games")
    public List<Game> games(ModelMap mm){
        return gamerepo.findAll();
    }

}
