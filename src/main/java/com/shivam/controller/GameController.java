package com.shivam.controller;

import java.io.IOException;
import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.repository.GameRepository;
import com.shivam.model.Game;

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
    public String games(ModelMap mm){
        return "gamesList";
    }

}
