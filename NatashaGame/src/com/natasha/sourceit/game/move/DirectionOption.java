package com.natasha.sourceit.game.move;

/**
 * Combination os direction with its probability. It is used when a chracter needs to select
 * new direction from several options
 */
public class DirectionOption {
    private Direction direction;
    private float probabilityPercent;

    @Override
    public String toString() {
        return String.format("{%s, p=%.1f}", direction, probabilityPercent);
    }

    public DirectionOption(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Direction is null");
        }
        this.direction = direction;
    }

    public DirectionOption(Direction direction, float probabilityPercent) {
        this(direction);
        if (probabilityPercent < 0f || probabilityPercent > 100f) {
            throw new IllegalArgumentException("Probability must be in 0 .. 100 inclusive. Got - "+probabilityPercent);
        }
        this.probabilityPercent = probabilityPercent;
    }

    public Direction getDirection() {
        return direction;
    }

    public float getProbabilityPercent() {
        return probabilityPercent;
    }

    public void setProbabilityPercent(float probabilityPercent) {
        if (probabilityPercent < 0f || probabilityPercent > 100f) {
            throw new IllegalArgumentException("Probability must be in 0 .. 100 inclusive. Got - "+probabilityPercent);
        }
        this.probabilityPercent = probabilityPercent;
    }

    @Override
    public int hashCode() {
        return direction.hashCode();
    }
}

