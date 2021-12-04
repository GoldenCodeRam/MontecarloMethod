package com.montecarlo.controller;

import com.montecarlo.model.Game;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController {
    private static final int MAX_GAMES = 5000;

    private static GameController instance;

    private GameController() {
        Logger.getGlobal().log(Level.INFO, "Generating new game controller");
    }

    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }

    public void startGames() {
        Game generalGame = new Game();

        for (int i = 0; i < MAX_GAMES; i++) {
            Logger.getGlobal().log(Level.FINE, String.format("Starting game %d", i));
            generalGame.startGame();
        }
    }
}
