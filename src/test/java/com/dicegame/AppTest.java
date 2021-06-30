package com.dicegame;

import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for a Drinking game.
 */

public class AppTest {
    private Dice dice;

    @Before
    public void init() {
        dice = RiggedDice.create(new int[][] { { 5, 4 }, { 3, 4 } });
    }

    @Test
    public void test_should_fail_fast() {

        // given
        Contestant czarek = new Contestant("Czarek", 81.4f);
        Contestant marcin = new Contestant("Marcin", 74.3f);

        // when
        DrinkingGame game = new DrinkingGame(dice, czarek, marcin);
        Result turn1result = game.playNextTurn();
        Result turn2result = game.playNextTurn();

        // assert
        MatcherAssert.assertThat(turn1result.getContestant(), is(czarek));
        MatcherAssert.assertThat(turn1result.getWon(), is(true));

        MatcherAssert.assertThat(turn2result.getContestant(), is(marcin));
        MatcherAssert.assertThat(turn2result.getWon(), is(false));
    }

    @Test
    public void test_should_won_when_roll_is_equal() {

        // given
        dice = RiggedDice.create(new int[][] { { 3, 4 }, { 1, 1 } });
        Contestant czarek = new Contestant("Czarek", 81.4f);
        Contestant marcin = new Contestant("Marcin", 74.3f);

        // when
        DrinkingGame game = new DrinkingGame(dice, czarek, marcin);
        Result turn1result = game.playNextTurn();
        Result turn2result = game.playNextTurn();

        // assert
        MatcherAssert.assertThat(turn1result.getContestant(), is(czarek));
        MatcherAssert.assertThat(turn1result.getWon(), is(true));

        MatcherAssert.assertThat(turn2result.getContestant(), is(marcin));
        MatcherAssert.assertThat(turn2result.getWon(), is(true));
    }

    @Test
    public void test_long_game() {

        // given
        dice = RiggedDice.create(new int[][] { { 3, 4 }, { 1, 3 } });
        Contestant czarek = new Contestant("Czarek", 81.4f);
        Contestant marcin = new Contestant("Marcin", 74.3f);
        Contestant jurek = new Contestant("Jurek", 90f);

        // when
        DrinkingGame game = new DrinkingGame(dice, czarek, marcin, jurek);
        Result turn1result = game.playNextTurn();
        Result turn2result = game.playNextTurn();
        Result turn3result = game.playNextTurn();
        Result turn4result = game.playNextTurn();
        Result turn5result = game.playNextTurn();

        // assert
        MatcherAssert.assertThat(turn1result.getContestant(), is(czarek));
        MatcherAssert.assertThat(turn1result.getWon(), is(true));

        MatcherAssert.assertThat(turn2result.getContestant(), is(marcin));
        MatcherAssert.assertThat(turn2result.getWon(), is(false));

        MatcherAssert.assertThat(turn3result.getContestant(), is(jurek));
        MatcherAssert.assertThat(turn3result.getWon(), is(true));

        MatcherAssert.assertThat(turn4result.getContestant(), is(czarek));
        MatcherAssert.assertThat(turn4result.getWon(), is(false));

        MatcherAssert.assertThat(turn5result.getContestant(), is(marcin));
        MatcherAssert.assertThat(turn5result.getWon(), is(true));

    }
}
