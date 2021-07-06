package com.dicegame;

import static org.hamcrest.core.Is.is;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Unit tests for a Drinking game.
 */
public class RollDiceTest {

    private Dice dice;
    private int throwsNumber;


    @Test
    public void should_return_array_with_1_element_for_1_roll() {

        //given
        dice = () -> 4;
        throwsNumber = 1;
        RollDice rollDice = new RollDice.RollDiceBuilder()
            .buildDice(dice)
            .buildThrowNumbers(throwsNumber)
            .build();

        //when
        int[] rollResults = rollDice.getResults();

        //then
        MatcherAssert.assertThat(rollResults[0], is(4));
        MatcherAssert.assertThat(rollResults.length, is(1));
    }

    @Test
    public void should_return_array_with_2_element_for_2_rolls() {

        //given
        dice = () -> 4;
        throwsNumber = 2;
        RollDice rollDice = new RollDice.RollDiceBuilder()
            .buildDice(dice)
            .buildThrowNumbers(throwsNumber)
            .build();

        //when
        int[] rollResults = rollDice.getResults();

        //then
        MatcherAssert.assertThat(rollResults[0], is(4));
        MatcherAssert.assertThat(rollResults[1], is(4));
        MatcherAssert.assertThat(rollResults.length, is(2));

    }

    @Test
    public void should_return_array_with_1_element_when_throw_number_is_0() {

        //given
        dice = () -> 4;
        throwsNumber = 0;
        RollDice rollDice = new RollDice.RollDiceBuilder()
            .buildDice(dice)
            .buildThrowNumbers(throwsNumber)
            .build();

        //when
        int[] rollResults = rollDice.getResults();

        //then
        MatcherAssert.assertThat(rollResults[0], is(4));
        MatcherAssert.assertThat(rollDice.getThrowsNumber(), is(1));
        MatcherAssert.assertThat(rollResults.length, is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_when_dice_object_is_null() {

        //given
        throwsNumber = 1;
        RollDice rollDice = new RollDice.RollDiceBuilder()
            .buildThrowNumbers(throwsNumber)
            .build();

        //when
        rollDice.getResults();
    }
}
