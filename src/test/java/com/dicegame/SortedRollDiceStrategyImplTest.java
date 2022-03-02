package com.dicegame;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortedRollDiceStrategyImplTest {

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
        rollDiceStrategy = new SortedRollDiceStrategyImpl();

        //assert
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> rollDiceStrategy.diceRoll(dice, numberOfRolls));
    }

    @Test
    void should_return_sorted_array_with_2_arguments_for_2_throws() {




    }


}