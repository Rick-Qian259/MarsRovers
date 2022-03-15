package service;

import entity.Command;
import entity.Direction;
import entity.Plateau;
import entity.Position;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputValidator {
    private static final String SEPARATOR = " ";
    private final Map<String, String> initRovers = new HashMap<>();

    public void checkInput(String fileName) throws IOException {
        List<String> inputText = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        if (incorrectPlateauFormat(inputText.get(0))) {
            throw new IllegalArgumentException("Incorrect input in line: " + inputText.get(0));
        }
        String[] inputTextArr = inputText.get(0).split(SEPARATOR);
        final Plateau plateau = new Plateau(new Position(Integer.parseInt(inputTextArr[0]), Integer.parseInt(inputTextArr[1])));

        for (String line : inputText.subList(1, inputText.size())) {
            if (Character.isDigit(line.charAt(0)) && (incorrectRoverFormat(line, plateau) || hasRover(line, initRovers))) {
                throw new IllegalArgumentException("Incorrect input in line: " + line);
            }
            if (Character.isLetter(line.charAt(0)) && incorrectInstruction(line)) {
                throw new IllegalArgumentException("Incorrect input in line: " + line);
            }
        }
    }

    private boolean incorrectPlateauFormat(String line) {
        String[] lineArray = line.split(SEPARATOR);
        return !(lineArray.length == 2 && isPositiveNum(lineArray[0], lineArray[1]));
    }

    private boolean incorrectInstruction(String line) {
        if (line.split(SEPARATOR).length != 1) {
            return true;
        }
        for (char ch : line.toCharArray()) {
            Command.valueOf(ch + "");
        }
        return false;
    }

    private boolean incorrectRoverFormat(String line, Plateau plateau) {
        String[] lineArray = line.split(SEPARATOR);
        if (lineArray.length != 3) {
            return true;
        }
        Direction.valueOf(lineArray[2]);
        return !(isPositiveNum(lineArray[0], lineArray[1])
                && plateau.inPlateau(Integer.parseInt(lineArray[0]), Integer.parseInt(lineArray[1])));
    }

    private boolean isPositiveNum(String strNum, String strNum2) {
        return Integer.parseInt(strNum) > 0 && Integer.parseInt(strNum2) > 0;
    }

    private boolean hasRover(String line, Map<String, String> initRovers) {
        String currentX = line.split(SEPARATOR)[0];
        String currentY = line.split(SEPARATOR)[1];
        if (initRovers.containsKey(currentX) && initRovers.containsValue(currentY)) {
            return true;
        }
        initRovers.put(currentX, currentY);
        return false;
    }

}
