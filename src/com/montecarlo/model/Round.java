package com.montecarlo.model;

public class Round {
    public void startRound(Team... teams) {
        for (Team team : teams) {
            // ... ya que el factor de suerte deberá ser calculado al principio de cada una de las rondas, para cada
            // equipo.
            team.setPlayersLuck();
            // Cada arquero hace X lanzamientos hasta terminar su resistencia. Estos lanzamientos conforman una ronda.
            team.makePlayerThrows();
            // En cada ronda, se sortea un lanzamiento por equipo, el cual será otorgado al jugador con más suerte de
            // cada uno de ellos.
            team.makeTeamThrow();
            // Gana una ronda individual, el arquero que de los dos equipos sume más puntos en sus lanzamientos. En caso
            // de empate, los contendientes tendrán lanzamientos extras hasta determinar un ganador.
        }
    }
}
