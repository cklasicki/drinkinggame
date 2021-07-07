package com.dicegame;


import static org.hamcrest.Matchers.is;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * Init tests for a Drinking game.
 */

public class PickContestantImplTest {

    private PickContestantStrategy pickContestantStrategy;
    private Contestant[] contestants;


    @BeforeEach
    public void init() {
        pickContestantStrategy = new PickContestantStrategyImpl();
        contestants = new Contestant[2];
    }

    @Test
    public void should_return_Contestant_number_one_on_first_turn() {

        //given
        contestants[0] = new Contestant("Czarek", 81.4f);
        contestants[1] = new Contestant("Marcin", 74.3f);
        int turn = 1;

        //when
        Contestant contestant = pickContestantStrategy.nextContestant(contestants,turn);

        //assert
        MatcherAssert.assertThat(contestant.getName(), is(contestants[0].getName()));
    }

    @Test
    public void should_return_Contestant_number_two_on_second_turn() {

        //given
        contestants[0] = new Contestant("Czarek", 81.4f);
        contestants[1] = new Contestant("Marcin", 74.3f);
        int turn = 2;

        //when
        Contestant contestant = pickContestantStrategy.nextContestant(contestants,turn);

        //assert
        MatcherAssert.assertThat(contestant.getName(), is(contestants[1].getName()));
    }

    @Test
    public void should_return_Contestant_number_one_on_third_turn() {

        //given
        contestants[0] = new Contestant("Czarek", 81.4f);
        contestants[1] = new Contestant("Marcin", 74.3f);
        int turn = 3;

        //when
        Contestant contestant = pickContestantStrategy.nextContestant(contestants,turn);

        //assert
        MatcherAssert.assertThat(contestant.getName(), is(contestants[0].getName()));
    }

    @Test
    public void should_throw_IllegalArgumentException_when_array_of_contestants_is_null() {

        //given
        //when
        int turn = 1;

        //assert
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> pickContestantStrategy.nextContestant(null,turn));
    }

    @Test
    public void should_throw_IllegalArgumentException_when_turn_value_is_equal_zero() {

        //given
        //when
        contestants[0] = new Contestant("Czarek", 81.4f);
        contestants[1] = new Contestant("Marcin", 74.3f);
        int turn = 0;

        //assert
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> pickContestantStrategy.nextContestant(contestants,turn));
    }

    @Test
    public void should_throw_IllegalArgumentException_when_turn_value_is_lower_than_zero() {

        //given
        //when
        contestants[0] = new Contestant("Czarek", 81.4f);
        contestants[1] = new Contestant("Marcin", 74.3f);
        int turn = -1;

        //assert
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> pickContestantStrategy.nextContestant(contestants,turn));
    }
}
