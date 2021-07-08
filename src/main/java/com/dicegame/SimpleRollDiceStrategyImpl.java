package com.dicegame;

import java.util.Objects;

public class SimpleRollDiceStrategyImpl implements RollDiceStrategy {

    @Override
    public RollDice diceRoll(Dice dice, int numberOfRolls) {

        if (Objects.isNull(dice) || numberOfRolls <= 0) {
            throw new IllegalArgumentException("Wrong data");
        }

        RollDice rollDice = new RollDice.RollDiceBuilder(dice)
            .buildThrowNumbers(numberOfRolls)
            .build();

        int[] result = rollDice.getResults();

        return rollDice;
    }
}
