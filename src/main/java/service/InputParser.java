package service;

import entity.*;
import lombok.Getter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Getter
public class InputParser {
    private static final String SEPARATOR = " ";
    private static final int commendCount = 0;
    private static final InputParser instance = new InputParser();
    private static final int commendNum = 0;
    private static int serialNumber = 0;

    private InputParser() {

    }

    public static InputParser getInstance() {
        return instance;
    }

    public UserInput parseInput(String fileName) throws IOException {
        List<String> inputList = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        return new UserInput(toPlateau(inputList.get(0)), toRoverListMap(inputList.subList(1, inputList.size())));
    }

    private Plateau toPlateau(String line) {
        String[] lineArray = line.split(SEPARATOR);
        return new Plateau(new Position(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1])));
    }

    private LinkedHashMap<Rover, List<Command>> toRoverListMap(List<String> inputList) {
        LinkedHashMap<Rover, List<Command>> roverListMap = new LinkedHashMap<>();
        Rover rover = new Rover();
        boolean newRover = false;
        StringBuffer sb = new StringBuffer();
        for (String line : inputList) {
            if (Character.isDigit(line.charAt(0))) {
                if (newRover) {
                    roverListMap.put(rover, toCommandList(sb));
                    sb = new StringBuffer();
                    newRover = false;
                }
                rover = toRover(line);
                newRover = true;
            } else {
                sb.append(line);
            }
        }
        if (newRover) {
            roverListMap.put(rover, toCommandList(sb));
        }
        return roverListMap;
    }

    private Rover toRover(String line) {
        String[] lineArr = line.split(SEPARATOR);
        serialNumber++;
        return new Rover(new Position(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1])), Direction.valueOf(lineArr[2]));
    }

    private List<Command> toCommandList(StringBuffer sb) {
        List<Command> commandList = new ArrayList<>();
        char[] charArr = sb.toString().toCharArray();
        for (char ch : charArr) {
            commandList.add(Command.valueOf(ch + ""));
        }
        return commandList;
    }

}
