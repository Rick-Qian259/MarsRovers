package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Position {
    private int x;
    private int y;

    public boolean inSamePosition(int roverX, int roverY) {
        return roverX == x && roverY == y;
    }
}
