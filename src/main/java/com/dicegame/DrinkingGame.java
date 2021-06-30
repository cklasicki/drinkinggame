package com.dicegame;

public class DrinkingGame {

    private Contestant[] contestants;
    private Dice dice;

    DrinkingGame(Dice dice, Contestant... contestants) {
        this.dice = dice;
        this.contestants = contestants;
    }

    public Result playNextTurn() {
        // TODO: to be implemented using OO guidelines
        return null;
    }
}