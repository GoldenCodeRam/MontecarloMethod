package com.montecarlo.model;

public class Game {
    // El equipo que obtenga más puntos al cabo de diez rondas gana el juego
    private static final int ROUNDS = 10;

    private final Team teamA = new Team();
    private final Team teamB = new Team();

    public void startGame() {
        for (int i = 0; i < ROUNDS; i++) {
            new Round().startRound(teamA, teamB);
        }
        // Al final de cada juego, el arquero recupera su resistencia original, y se devuelven sus puntos a cero.
        teamA.resetPlayers();
        teamB.resetPlayers();
    }
}
