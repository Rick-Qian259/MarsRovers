package entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Plateau {
    private final Position position;

    public boolean inPlateau(int x, int y) {
        return x >= 0 && y >= 0 && x <= position.getX() && y <= position.getY();
    }

}
