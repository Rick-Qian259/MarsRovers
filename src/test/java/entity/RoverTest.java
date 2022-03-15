package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoverTest {
    private final LinkedHashMap<Rover, List<Command>> roverListMap = new LinkedHashMap<>();
    private final List<Command> commandList = new ArrayList<Command>(Arrays.asList(Command.M));
    private final List<Command> commandList2 = new ArrayList<Command>(Arrays.asList(Command.M, Command.M));
    private Plateau plateau;
    private Rover rover1;
    private Rover rover2;
    private Rover rover3;
    private Position position1;
    private Position position2;

    @BeforeEach
    void init() {
        rover1 = new Rover(new Position(1, 1), Direction.N);
        rover2 = new Rover(new Position(3, 3), Direction.N);
        plateau = new Plateau(new Position(5, 5));
        roverListMap.put(rover1, commandList);
        roverListMap.put(rover2, commandList2);
        position1 = new Position(1, 3);
        rover3 = new Rover();

    }

    @Test
    void moveToNorthSuccess() {
        rover1.moveRover(roverListMap, plateau);
        assertEquals(new Position(1, 2), rover1.getPosition());
    }

    @Test
    void moveToSouthSuccess() {
        rover1.setDirection(Direction.S);
        rover1.moveRover(roverListMap, plateau);
        assertEquals(new Position(1, 0), rover1.getPosition());
    }

    @Test
    void moveToWestSuccess() {
        rover1.setDirection(Direction.W);
        rover1.moveRover(roverListMap, plateau);
        assertEquals(new Position(0, 1), rover1.getPosition());
    }

    @Test
    void moveToEastSuccess() {
        rover1.setDirection(Direction.E);
        rover1.moveRover(roverListMap, plateau);
        assertEquals(new Position(2, 1), rover1.getPosition());
    }

    @Test
    void roverCrash() {
        rover2.setPosition(new Position(1, 2));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rover1.moveRover(roverListMap, plateau);
        });
        assertEquals("Rovers crash in position:[ 1 , 2 ]", exception.getMessage());
    }

    @Test
    void roverOutOfPlateau() {
        rover2.setPosition(new Position(1, 5));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            rover2.moveRover(roverListMap, plateau);
        });
        assertEquals("A rover has out of Plateau in position:[ 1 , 6 ]", exception.getMessage());
    }

    @Test
    void turnLeft() {
        rover1.rotateRover(Command.L);
        assertEquals(Direction.W, rover1.getDirection());
    }

    @Test
    void turnRight() {
        rover1.rotateRover(Command.R);
        assertEquals(Direction.E, rover1.getDirection());
    }

    @Test
    void testToString() {
        String expectOutput = "1 1 N";
        assertEquals(expectOutput, rover1.toString());
    }
}