package com.dicegame;

import java.util.Arrays;
import java.util.Objects;

public class SortedRollDiceStrategyImpl implements RollDiceStrategy {
    @Override
    public RollDice diceRoll(Dice dice, int numberOfRolls) {

        if (Objects.isNull(dice)) {
            throw new IllegalArgumentException("Wrong data");
        }

        RollDice rollDice = new RollDice.RollDiceBuilder(dice)
            .buildThrowNumbers(numberOfRolls)
            .build();

        int[] result = rollDice.getResults();

        Arrays.sort(result);

        return rollDice;

    }
}
