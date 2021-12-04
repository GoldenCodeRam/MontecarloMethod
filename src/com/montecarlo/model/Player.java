package com.montecarlo.model;

import java.util.Random;

public class Player {
    private static final int BASE_RESISTANCE = 40;
    private static final int DELTA_RESISTANCE = 10;
    private static final int BASE_EXPERIENCE = 10;
    private static final float MAX_BASE_LUCK = 5f;
    // Cada lanzamiento utiliza 5 puntos de resistencia
    private static final int THROW_RESISTANCE_COST = 5;

    public final boolean isMale;
    private final int startResistance;
    private final int startExperience;

    private int resistance;
    private int experience;
    private float luck;

    private int score = 0;
    private int consecutiveTeamThrows = 0;
    private int previousResistance;

    public Player() {
        this.startResistance = BASE_RESISTANCE + (new Random().nextBoolean() ? DELTA_RESISTANCE : -DELTA_RESISTANCE);
        this.startExperience = BASE_EXPERIENCE;
        this.isMale = new Random().nextBoolean();

        this.previousResistance = this.startResistance;
    }

    /**
     * Explanation: Cada arquero hace X lanzamientos hasta terminar su resistencia. Estos lanzamientos conforman una ronda.
     */
    public void makeThrows() {
        this.resistance = this.previousResistance;
        while (resistance > 0) {
            score += Throw.getThrow(this);
            resistance -= THROW_RESISTANCE_COST;
        }
        // Al final de cada ronda, el arquero recupera los puntos de resistencia de su ronda anterior menos una o dos
        // unidades, las cuales representan el cansancio por el juego.
        this.previousResistance -= new Random().nextBoolean() ? 1 : 2;
    }

    /**
     * Resets the player resistance to the initial resistance, when it was created.
     */
    public void resetResistance() {
        this.previousResistance = this.startResistance;
    }

    public void resetScore() {
        this.score = score;
    }

    public void resetConsecutiveTeamThrows() {
        this.consecutiveTeamThrows = 0;
    }

    public void increaseConsecutiveTeamThrows() {
        this.consecutiveTeamThrows++;
    }

    public int getConsecutiveTeamThrows() {
        return this.consecutiveTeamThrows;
    }

    public void setRandomLuck() {
        this.luck = new Random().nextFloat(MAX_BASE_LUCK);
    }

    public float getLuck() {
        return this.luck;
    }
}
