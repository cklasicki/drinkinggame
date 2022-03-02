package com.dicegame;

public class DrunkResult {
    
    private Contestant contestant;
    private boolean drunk;
    
    DrunkResult(Contestant contestant, boolean drunk) {
        this.contestant = contestant;
        this.drunk = drunk;
    }

    public boolean isDrunk() {
        return drunk;
    }

    public Contestant getContestant() {
        return contestant;
    }

    
}
