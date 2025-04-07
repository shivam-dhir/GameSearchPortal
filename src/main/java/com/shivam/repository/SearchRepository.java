package com.shivam.repository;

import java.util.List;

import com.shivam.model.Game;

public interface SearchRepository {

    List<Game> searchGame(String query);
}
