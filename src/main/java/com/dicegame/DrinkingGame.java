package com.dicegame;

public class DrinkingGame {

    private Contestant[] contestants;
    private Dice dice;
    private float shot_amount = 0.4f;
    private float drunk_threshold = 0.05f;

    DrinkingGame(Dice dice, Contestant... contestants) {
        this.dice = dice;
        this.contestants = contestants;
    }

    public Result playNextTurn() {
        // TODO: to be implemented using OO guidelines
        return null;
    }

    public DrunkResult checkIfDrunk(Result result) {
        // TODO: to be implemented using OO guidelines
        return null;
    }

    public String winnerIs() {
       // TOD: to be implemented using OO guidelines
       return null; 
    }
}