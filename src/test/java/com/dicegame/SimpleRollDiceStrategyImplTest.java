package com.dicegame;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SimpleRollDiceStrategyImplTest {

    private int numberOfRolls;
    private Dice dice;
    private RollDiceStrategy rollDiceStrategy;
    private RollDice rollDice;

    @Test
    void should_throw_IllegalArgumentException_when_number_of_throws_is_0() {

        //given
        //when
        dice = () -> 2;
        numberOfRolls = 0;
        rollDiceStrategy = new SimpleRollDiceStrategyImpl();

        //assert
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> rollDiceStrategy.diceRoll(dice, numberOfRolls));
    }

    @Test
    void should_return_RollDice_with_1_argument_in_array_for_1_throw() {

        //given
        dice = () -> 2;
        numberOfRolls = 1;
        rollDiceStrategy = new SimpleRollDiceStrategyImpl();

        //when
        rollDice = rollDiceStrategy.diceRoll(dice,numberOfRolls);

        //then
        MatcherAssert.assertThat(rollDice.getResults().length, is(1));
        MatcherAssert.assertThat(rollDice.getResults()[0], is(2));
    }

    @Test
    void should_return_RollDice_with_3_arguments_in_array_for_3_throws() {

        //given
        dice = () -> 2;
        numberOfRolls = 3;
        rollDiceStrategy = new SimpleRollDiceStrategyImpl();
        int[] testData = {2,2,2};

        //when
        rollDice = rollDiceStrategy.diceRoll(dice,numberOfRolls);

        //then
        MatcherAssert.assertThat(rollDice.getResults().length, is(3));
        assertArrayEquals(testData,rollDice.getResults());
    }
}