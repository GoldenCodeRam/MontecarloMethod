package com.montecarlo.model;

import java.util.Random;

public class Throw {
    public static int getThrow(Player player) {
        return player.isMale ? getMalePlayerThrowResult() : getFemalePlayerThrowResult();
    }

    private static int getMalePlayerThrowResult() {
        int probability = new Random().nextInt(0, 101);

        if (ThrowResult.ERROR.maleStartBound <= probability && probability <= ThrowResult.ERROR.maleEndBound) {
            return ThrowResult.ERROR.points;
        } else if (ThrowResult.OUT.maleStartBound <= probability && probability <= ThrowResult.OUT.maleEndBound) {
            return ThrowResult.OUT.points;
        } else if (ThrowResult.MIDDLE.maleStartBound <= probability && probability <= ThrowResult.MIDDLE.maleEndBound) {
            return ThrowResult.MIDDLE.points;
        } else {
            return ThrowResult.CENTER.points;
        }
    }

    private static int getFemalePlayerThrowResult() {
        int probability = new Random().nextInt(0, 101);

        if (ThrowResult.ERROR.femaleStartBound <= probability && probability <= ThrowResult.ERROR.femaleEndBound) {
            return ThrowResult.ERROR.points;
        } else if (ThrowResult.OUT.femaleStartBound <= probability && probability <= ThrowResult.OUT.femaleEndBound) {
            return ThrowResult.OUT.points;
        } else if (ThrowResult.MIDDLE.femaleStartBound <= probability && probability <= ThrowResult.MIDDLE.femaleEndBound) {
            return ThrowResult.MIDDLE.points;
        } else {
            return ThrowResult.CENTER.points;
        }
    }

    public enum ThrowResult {
        ERROR(
                0, 7, 0, 5, 0
        ),
        OUT(
                60, 100, 5, 32, 8
        ),
        MIDDLE(
                27, 60, 62, 100, 9
        ),
        CENTER(
                7, 27, 32, 62, 10
        );

        public final int maleStartBound;
        public final int maleEndBound;
        public final int femaleStartBound;
        public final int femaleEndBound;
        public final int points;

        ThrowResult(int maleStartBound, int maleEndBound, int femaleStartBound, int femaleEndBound, int points) {
            this.maleStartBound = maleStartBound;
            this.maleEndBound = maleEndBound;
            this.femaleStartBound = femaleStartBound;
            this.femaleEndBound = femaleEndBound;
            this.points = points;
        }
    }
}
