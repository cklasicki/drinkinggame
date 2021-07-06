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
    public void should_return_array_with_1_element_with_default_number_of_throws() {

        //given
        dice = () -> 4;
        RollDice rollDice = new RollDice.RollDiceBuilder(dice).build();

        //when
        int[] rollResults = rollDice.getResults();

        //then
        MatcherAssert.assertThat(rollResults[0], is(4));
        MatcherAssert.assertThat(rollResults.length, is(1));
    }

    @Test
    public void should_return_array_with_1_element_for_1_roll() {

        //given
        dice = () -> 4;
        throwsNumber = 1;
        RollDice rollDice = new RollDice.RollDiceBuilder(dice)
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
        RollDice rollDice = new RollDice.RollDiceBuilder(dice)
            .buildThrowNumbers(throwsNumber)
            .build();

        //when
        int[] rollResults = rollDice.getResults();

        //then
        MatcherAssert.assertThat(rollResults[0], is(4));
        MatcherAssert.assertThat(rollResults[1], is(4));
        MatcherAssert.assertThat(rollResults.length, is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_IllegalArgumentException_when_dice_object_is_null() {

        //given
        RollDice rollDice = new RollDice.RollDiceBuilder(null).build();

        //when
        //then
        rollDice.getResults();
    }

}
