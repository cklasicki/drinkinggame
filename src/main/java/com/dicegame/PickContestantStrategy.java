package com.dicegame;

/**
 * Interface that will return next Contestant.
 */

public interface PickContestantStrategy {

    /**
     * Method that returns next Contestant
     *
     * @param contestants array of Contestants objects
     * @param turn number of turn in the game
     * @return current contestant
     */
    Contestant nextContestant(Contestant[] contestants, int turn);
}

