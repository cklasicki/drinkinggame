package com.dicegame;

import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Unit tests for a Drinking game.
 */

public class RiggedDiceTests 
{
    private Dice dice;

    @BeforeEach
    public void init() {
        dice = RiggedDice.create(new int[][]{{4,2},{5,3}});
    }

    @Test
    public void should_provide_good_result_1_throw() {

        // given a dice

        // when
        int firstThrow = dice.rollDice();
        int secondThrow = dice.rollDice();

        // assert
        MatcherAssert.assertThat(firstThrow, is(4));
        MatcherAssert.assertThat(secondThrow, is(2));
    }

    @Test
    public void should_provide_good_result_2_throw() {

        // given a dice

        // when
        for (int i=0; i<2; i++) {
            dice.rollDice(); //omit this roll
        }
        int thirdThrow = dice.rollDice();
        int fourthResult = dice.rollDice();

        // assert
        MatcherAssert.assertThat(thirdThrow, is(5));
        MatcherAssert.assertThat(fourthResult, is(3));
    }

    @Test
    public void should_provide_good_result_3_throw() {

        // given a dice

        // when
        for (int i=0; i<4; i++) {
            dice.rollDice(); //omit this roll
        }

        int firstThrow = dice.rollDice();
        int secondThrow = dice.rollDice();

        // assert
        MatcherAssert.assertThat(firstThrow, is(4));
        MatcherAssert.assertThat(secondThrow, is(2));
    }
}
