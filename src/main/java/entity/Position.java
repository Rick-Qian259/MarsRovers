package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    public Position moveByOffset(Position position) {
        return new Position(x + position.getX(), y + position.getY());
    }

    public boolean inSamePosition(int roverX, int roverY) {
        return roverX == x && roverY == y;
    }
}
