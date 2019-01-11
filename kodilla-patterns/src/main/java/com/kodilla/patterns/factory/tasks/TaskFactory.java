package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DOSHOPING = "DOSHOPING";
    public static final String PAINT = "PAINT";
    public static final String DRIVE = "DRIVE";

    public final Task doSomething(final String activity) {
        switch (activity) {
            case DOSHOPING:
                return new ShoppingTask("buy", "board game", 2);
            case PAINT:
                return new PaintingTask("paint", "emerald", "one-eyed dragon");
            case DRIVE:
                return new DrivingTask("drive", "end of the road", "hydrogen car");
            default:
                return null;
        }
    }
}
