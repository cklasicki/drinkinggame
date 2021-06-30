package com.dicegame;

/**
 * Mocked implementation of a Dice that will always return predefined values
 */
public class RiggedDice implements Dice {

    private int[][] predefinedRolls;
    private int currentRoll;
    private int currentThrow;
    private int numberOfThrows;
    private static int NUMBER_OF_ROLLS = 2;

    private static RiggedDice dice;

    private RiggedDice(int[][] predefinedRolls) {
        this.predefinedRolls = predefinedRolls;
        this.numberOfThrows = predefinedRolls.length;
    }

    public static RiggedDice create(int[][] predefinedRolls) {
        if (dice == null)
            return new RiggedDice(predefinedRolls);
        else
            return dice;
    }

    @Override
    public int rollDice() {

        int curRoll = currentRoll++ % NUMBER_OF_ROLLS;
        int curThrow = calculateCurrentThrow(curRoll);

        return predefinedRolls[curThrow][curRoll];
    }

    private int calculateCurrentThrow(int currentRoll) {
        if (currentRoll >= NUMBER_OF_ROLLS - 1) {
            return currentThrow++%numberOfThrows;
        }
        else {
            return currentThrow%numberOfThrows;
        }
    }
}