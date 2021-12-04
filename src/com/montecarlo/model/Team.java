package com.montecarlo.model;

public class Team {
    private static final int TEAM_SIZE = 6;
    // Si un jugador gana tres lanzamientos extra de forma consecutiva tiene derecho a un lanzamiento extra.
    private static final int CONSECUTIVE_TEAM_THROWS_BONUS = 3;

    private final Player[] players = new Player[TEAM_SIZE];
    private int score = 0;

    public Team() {
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
    }

    public void setPlayersLuck() {
        for (Player player : this.players) {
            player.setRandomLuck();
        }
    }

    public void makePlayerThrows() {
        for (Player player : this.players) {
            player.makeThrows();
        }
    }

    public void resetPlayers() {
        for (Player player : this.players) {
            player.resetResistance();
            player.resetScore();
        }
    }

    public void resetConsecutiveTeamThrows() {
        for (Player player : this.players) {
            player.resetConsecutiveTeamThrows();
        }
    }

    /**
     * Explanation: En cada ronda se sortea un lanzamiento por equipo.
     */
    public void makeTeamThrow() {
        // El cual será otorgado al jugador con más suerte de cada uno de ellos.
        Player luckiestPlayer = this.players[0];
        for (Player player : this.players) {
            if (luckiestPlayer.getLuck() < player.getLuck()) {
                luckiestPlayer = player;
            }
        }
        // El lanzamiento se tendrá en cuenta para el marcador global del grupo, no para determinar el ganador de la
        // ronda individual
        this.score += Throw.getThrow(luckiestPlayer);
        // Si un jugador gana tres lanzamientos extra de forma consecutiva, tiene derecho a un lanzamiento extra, sin
        // importar el valor de la resistencia
        luckiestPlayer.increaseConsecutiveTeamThrows();
        if (luckiestPlayer.getConsecutiveTeamThrows() == CONSECUTIVE_TEAM_THROWS_BONUS) {
            this.score += Throw.getThrow(luckiestPlayer);
            this.resetConsecutiveTeamThrows();
        }
        // Reset all other players consecutive team throws, because they are not consecutive anymore.
        for (Player player : this.players) {
            if (player != luckiestPlayer) {
                player.resetConsecutiveTeamThrows();
            }
        }
    }
}
