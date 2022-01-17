package ie.gmit.dip;

public abstract class Playable implements Comparable<Chat> {
    private int maxDistance;

    public void fish (Chat type) {
        // Implementation
    }

    abstract public int cast(int distance);
}
