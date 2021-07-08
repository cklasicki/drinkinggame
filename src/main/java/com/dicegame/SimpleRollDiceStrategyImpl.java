package com.dicegame;

import java.util.Objects;

public class SimpleRollDiceStrategyImpl implements RollDiceStrategy {

    @Override
    public RollDice diceRoll(Dice dice, int numberOfRolls) {

        if (Objects.isNull(dice)) {
            throw new IllegalArgumentException("Wrong data");
        }

        return new RollDice.RollDiceBuilder(dice)
            .buildThrowNumbers(numberOfRolls)
            .build();
    }
}
