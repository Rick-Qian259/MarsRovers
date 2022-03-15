package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rover {
    private final Map<Direction, Position> directionOffset = Map.of(
            Direction.N, new Position(0, 1),
            Direction.E, new Position(1, 0),
            Direction.S, new Position(0, -1),
            Direction.W, new Position(-1, 0)
    );
    private Position position;
    private Direction direction;

    public void moveRover(LinkedHashMap<Rover, List<Command>> roverListMap, Plateau plateau) {
        Position tryMoveTo = position.moveByOffset(directionOffset.get(direction));
        checkCrash(roverListMap, tryMoveTo.getX(), tryMoveTo.getY());
        position = tryMoveTo;
        if (!plateau.inPlateau(position.getX(), position.getY())) {
            throw new IllegalArgumentException("A rover has out of Plateau in position:[ " + position.getX() + " , " + position.getY() + " ]");
        }
    }

    private void checkCrash(LinkedHashMap<Rover, List<Command>> roverListMap, int x, int y) {
        roverListMap.forEach((k, v) -> {
            if (k.position.inSamePosition(x, y)) {
                throw new IllegalArgumentException("Rovers crash in position:[ " + x + " , " + y + " ]");
            }
        });
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(position.getX()).append(" ").append(position.getY()).append(" ").append(direction);
        return sb.toString();
    }

    public void rotateRover(Command command) {
        int enumOrdinal = 0;
        enumOrdinal += (direction.ordinal() + Direction.values().length + command.getNumber()) % Direction.values().length;
        setDirection(Direction.values()[enumOrdinal]);
    }
}
