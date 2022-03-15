package service;

import entity.Rover;
import entity.UserInput;

import java.io.IOException;
import java.util.List;

public class Execution {
    private final InputParser inputParser = InputParser.getInstance();
    private final InputValidator inputValidator = new InputValidator();
    private final Controller controller = new Controller();
    private List<Rover> rovers;

    public void execute(String fileName) throws IOException {
        inputValidator.checkInput(fileName);
        UserInput userInput = inputParser.parseInput(fileName);
        rovers = controller.operateRovers(userInput);
        controller.reportRoverStatus(rovers);
    }
}
