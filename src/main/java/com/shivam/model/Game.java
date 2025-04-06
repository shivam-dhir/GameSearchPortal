package com.shivam.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;

public class Game {
    
    private int _id;
    private String name;
    private String desc;
    private int yor;
    private int metascore;
    private String[] genre;
    
    public Game(int _id, String name, String desc, int yor, int metascore, String[] genre) {
        this._id = _id;
        this.name = name;
        this.desc = desc;
        this.yor = yor;
        this.metascore = metascore;
        this.genre = genre;
    }
    public int get_id() {
        return _id;
    }
    public void set_id(int _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getYor() {
        return yor;
    }
    public void setYor(int yor) {
        this.yor = yor;
    }
    public int getMetascore() {
        return metascore;
    }
    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }
    public String[] getGenre() {
        return genre;
    }
    public void setGenre(String[] genre) {
        this.genre = genre;
    }
    
    @Override
    public String toString() {
        return "Game [_id=" + _id + ", name=" + name + ", desc=" + desc + ", yor=" + yor + ", metascore=" + metascore
                + ", genre=" + Arrays.toString(genre) + "]";
    }

}
