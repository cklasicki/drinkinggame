package com.dicegame;

/**
 * Class that represents a result of rolling dice
 */

public class RollDice {

    private Dice dice;
    private int throwsNumber;

    private RollDice(RollDiceBuilder rollDiceBuilder) {
        this.dice = rollDiceBuilder.dice;
        this.throwsNumber = rollDiceBuilder.throwsNumber;
    }

    public Dice getDice() {
        return dice;
    }

    public int getThrowsNumber() {
        return throwsNumber;
    }

    /**
     *  Method that returns result of dice roll.
     *  When dice object is null, IllegalArgumentException
     *  will be thrown.
     * @return array of results for rolling dice
     *
     */

    public int[] getResults() {
        if (dice == null) {
            throw new IllegalArgumentException("Wrong data");
        }

        int[] results = new int[throwsNumber];

        for (int i = 0; i < throwsNumber; i++) {
            results[i] = dice.rollDice();
        }

        return results;
    }

    /**
     * Inner class for building RollDice object.
     * Default value for number of throws is 1.
     * You can overwrite it with buildTrowNumbers() method.
     */

    public static class RollDiceBuilder {
        private Dice dice;
        private int throwsNumber;

        public RollDiceBuilder(Dice dice) {
            this.dice = dice;
            this.throwsNumber = 1;
        }

        public RollDiceBuilder buildThrowNumbers(int throwsNumber) {
            this.throwsNumber = throwsNumber;
            return this;
        }

        public RollDice build() {
            if (throwsNumber == 0) {
               throw new IllegalArgumentException("Number of throws must be greater than 0");
            }
            return new RollDice(this);
        }
    }

}
