package com.shivam.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.w3c.dom.ranges.DocumentRange;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shivam.model.Game;

@Component
public class MongoRepository implements SearchRepository{

    // mongo client to connect to database
    @Autowired
    MongoClient mongoClient;

    // convert mongo document to java object
    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Game> searchGame(String query) {

        MongoDatabase database = mongoClient.getDatabase("shivam");
        MongoCollection<Document> collection = database.getCollection("gamedirectory");
        
        final List<Game> searchQueryGames = new ArrayList<>();

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", 
                                                        new Document("index", "default")
                                                                    .append("text", 
                                                        new Document("query", query)
                                                                    .append("path", Arrays.asList("desc", "genre", "name", "yor")))), 
                                                        new Document("$sort", 
                                                        new Document("score", 1L)), 
                                                        new Document("$limit", 5L)));

        result.forEach(doc -> searchQueryGames.add(mongoConverter.read(Game.class, doc)));

        return searchQueryGames;
                                                           
    }



}
