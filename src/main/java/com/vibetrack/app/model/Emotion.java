package com.vibetrack.app.model;

public enum Emotion {
    HAPPY(5),
    PRODUCTIVE(4),
    NEUTRAL(3),
    TIRED(2),
    SAD(1),
    STRESSED(0);

    private final int value;

    Emotion(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
