package entity;

public enum Command {
    M(0), L(-1), R(1);

    private final int number;

    Command(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
