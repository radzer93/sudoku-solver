package com.kodilla.sudoku.main;

import com.kodilla.sudoku.game.Game;

/**
 * Author: Radosław Żerek
 */

public class Application {
    public static void main(String[] args) {
        boolean gameFinished = false;

        while (!gameFinished) {
            Game game = new Game();
            gameFinished = game.resolve();
        }
    }
}
