package com.dicegame;

/**
 *  Class that represents a result of rolling dice
 */

public class RollDice {
    private Dice dice;
    private int throwsNumber;

    /**
     * Constructor to create RollDice object
     * @param dice implementation for Dice interface
     * @param throwsNumber number of throws
     */

    public RollDice(Dice dice, int throwsNumber) {
        this.dice = dice;
        this.throwsNumber = throwsNumber;
    }

    /**
     * Method that returns array of throw results
     * @return array of rolling dice results
     */
    public int[] getResults() {

        int[] results = new int[throwsNumber];

        for (int i = 0; i < throwsNumber; i++) {
            results[i] = dice.rollDice();
        }

        return results;
    }
}
