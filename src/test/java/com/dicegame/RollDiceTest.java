package com.dicegame;

import static org.hamcrest.core.Is.is;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

/**
 *  Unit tests for a Drinking game.
 */
public class RollDiceTest {

    private RollDice rollDice;
    private Dice dice;
    private int throwsNumber;

    @Before
    public void init() {
        rollDice = new RollDice(dice,throwsNumber);
    }

    @Test
    public void should_return_array_with_1_element_for_1_roll() {

        //given
        dice = () -> 4;
        throwsNumber = 1;
        rollDice = new RollDice(dice,throwsNumber);
        //when
        int [] rollResults =  rollDice.getResults();

        //then
        MatcherAssert.assertThat(rollResults[0], is(4));
    }

    @Test
    public void should_return_array_with_2_element_for_2_rolls() {

        //given
        dice = () -> 4;
        throwsNumber = 2;
        rollDice = new RollDice(dice,throwsNumber);
        //when
        int [] rollResults =  rollDice.getResults();

        //then
        MatcherAssert.assertThat(rollResults[0], is(4));
        MatcherAssert.assertThat(rollResults[1], is(4));
    }

}
