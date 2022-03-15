package service;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;
    private UserInput userInput;
    private final LinkedHashMap<Rover, List<Command>> roverListMap = new LinkedHashMap<>();
    private final LinkedHashMap<Rover, List<Command>> roverListMap2 = new LinkedHashMap<>();
    private final List<Command> commandList = new ArrayList<Command>(Arrays.asList(Command.M));
    private final List<Command> commandList2 = new ArrayList<Command>(Arrays.asList(Command.M, Command.M));
    private final List<Command> commandList3 = new ArrayList<>();
    private Rover rover1;
    private Rover rover2;

    @BeforeEach
    void init() {
        rover1 = new Rover(new Position(1, 1), Direction.N);
        rover2 = new Rover(new Position(3, 3), Direction.N);
        controller = new Controller();
        roverListMap.put(rover1, commandList);
        roverListMap.put(rover2, commandList2);
        userInput = new UserInput(new Plateau(new Position(5, 5)), roverListMap);
    }

    @Test
    void operateRoversTest() {
        List<Rover> list = controller.operateRovers(userInput);
        List<Rover> expectList = new ArrayList<>();
        expectList.add(new Rover(new Position(1,2), Direction.N));
        expectList.add(new Rover(new Position(3,5), Direction.N));
        assertEquals(expectList, list);
    }

    @Test
    void aRoverHasNoCommand() {
        roverListMap2.put(rover1,commandList);
        roverListMap2.put(rover2,commandList3);
        userInput = new UserInput(new Plateau(new Position(5, 5)), roverListMap2);
        List<Rover> list = controller.operateRovers(userInput);
        List<Rover> expectList = new ArrayList<>();
        expectList.add(new Rover(new Position(1,2), Direction.N));
        expectList.add(new Rover(new Position(3,3), Direction.N));
        assertEquals(expectList, list);
    }
}