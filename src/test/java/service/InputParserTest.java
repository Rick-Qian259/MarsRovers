package service;

import entity.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    private final InputParser inputParser = InputParser.getInstance();

    @Test
    void parseInput() throws IOException {
        UserInput userInput = inputParser.parseInput("testCases/input14");

        System.out.println("1");
        LinkedHashMap<Rover, List<Command>> roverListMap = new LinkedHashMap<>();
        List<Command> list1 = new ArrayList<>();
        list1.add(Command.L);
        list1.add(Command.M);
        List<Command> list2 = new ArrayList<>();
        list2.add(Command.M);
        list2.add(Command.L);
        Rover rover1 = new Rover(new Position(1,2),Direction.N);
        Rover rover2 = new Rover(new Position(3,3),Direction.E);
        roverListMap.put(rover1,list1);
        roverListMap.put(rover2,list2);
        UserInput expectUserInput = new UserInput(new Plateau(new Position(5,5)),roverListMap);
        assertEquals(expectUserInput, userInput);
    }
}