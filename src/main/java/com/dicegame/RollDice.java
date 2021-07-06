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
     */

    public static class RollDiceBuilder {
        private Dice dice;
        private int throwsNumber;

        public RollDiceBuilder buildDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public RollDiceBuilder buildThrowNumbers(int throwsNumber) {
            if (throwsNumber <= 0) {
                throwsNumber = 1;
            }
            this.throwsNumber = throwsNumber;
            return this;
        }

        public RollDice build() {
            return new RollDice(this);
        }
    }

}
