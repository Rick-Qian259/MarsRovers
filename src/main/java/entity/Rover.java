package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rover {
    private Position position;
    private Direction direction;

    public void moveRover(LinkedHashMap<Rover, List<Command>> roverListMap, Plateau plateau) {
        if (direction.name().equals("N") || direction.name().equals("S")) {
            int movedY = position.getY() + direction.getNumber();
            checkCrash(roverListMap, position.getX(), movedY);
            position.setY(movedY);
        } else {
            int movedX = position.getX() + direction.getNumber();
            checkCrash(roverListMap, movedX, position.getY());
            position.setX(movedX);
        }
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
        if (command.equals(Command.L)) {
            enumOrdinal += (direction.ordinal() + Direction.values().length - 1) % Direction.values().length;
        } else {
            enumOrdinal += (direction.ordinal() + Direction.values().length + 1) % Direction.values().length;
        }
        setDirection(Direction.values()[enumOrdinal]);
    }
}
