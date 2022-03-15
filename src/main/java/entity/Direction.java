package entity;

public enum Direction {
    N(1),
    E(1),
    S(-1),
    W(-1);

    private final int number;

    Direction(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
