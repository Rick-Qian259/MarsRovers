package service;

import entity.Command;
import entity.Rover;
import entity.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<Rover> operateRovers(UserInput userInput) {
        List<Rover> rovers = new ArrayList<>();
        userInput.getRoverListMap().forEach((rover, commands) -> {
            rovers.add(operateRover(rover, commands, userInput));
        });
        return rovers;
    }

    private Rover operateRover(Rover rover, List<Command> commands, UserInput userInput) {
        commands.forEach(command -> {
            if (command.equals(Command.M)) {
                rover.moveRover(userInput.getRoverListMap(), userInput.getPlateau());
            } else {
                rover.rotateRover(command);
            }
        });
        return rover;
    }

    public void reportRoverStatus(List<Rover> rovers) {
        rovers.forEach(rover -> {
            System.out.println(rover.toString());
        });
    }
}
