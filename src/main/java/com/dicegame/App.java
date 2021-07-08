package com.dicegame;


import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        RollDiceStrategy rollDiceStrategy = new SimpleRollDiceStrategyImpl();
        RollDice rollDice =  rollDiceStrategy.diceRoll((() -> new Random().nextInt(6) + 1),0);

        System.out.println("Ilość rzutów " + rollDice.getThrowsNumber());

        for (int result : rollDice.getResults()) {
            System.out.println(result);
        }


    }
}
