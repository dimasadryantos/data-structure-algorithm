package com.main;

public class Player {

    public String name;
    public int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public String toString() {
        return this.score + " " + this.name;
    }
}
