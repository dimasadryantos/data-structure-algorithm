package com.main;

import java.util.Comparator;

public class SortByName implements Comparator<Player> {


    @Override
    public int compare(Player a, Player b) {
        if (a.score > b.score) {
            return -1;
        } else if (a.score < b.score) {
            return 1;
        }

        /*else{
           return a.name.compareTo(b.name);
       }*/


        return 0;
    }
}
