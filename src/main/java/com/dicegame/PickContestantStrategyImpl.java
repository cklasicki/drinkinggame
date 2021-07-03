package com.dicegame;

public class PickContestantStrategyImpl implements PickContestantStrategy {
    @Override
    public Contestant nextContestant(Contestant[] contestants, int turn) {

        if (contestants == null || turn <= 0) {
            throw new IllegalArgumentException("Wrong data");
        }

        return contestants[(turn + contestants.length - 1) % contestants.length];
    }
}
