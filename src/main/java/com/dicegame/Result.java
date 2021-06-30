package com.dicegame;

/**
 * The result of the game that provides information about contestant and the result itself
 */
public class Result {

    private Contestant contestant;
    private boolean won;

    Result(Contestant contestant, boolean won) {
        this.contestant = contestant;
        this.won = won;
    }

    public Contestant getContestant() {
        return this.contestant;
    }

    public boolean getWon() {
        return this.won;
    }
}