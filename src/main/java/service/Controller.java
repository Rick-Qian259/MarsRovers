package service;

import entity.Command;
import entity.Rover;
import entity.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<Rover> operateRovers(UserInput userInput) {
        List<Rover> rovers = new ArrayList<>();
        userInput.getRoverListMap().forEach((key, value) -> {
            if (value.size() != 0) {
                rovers.add(operateRover(key, value, userInput));
            }
            else {
                rovers.add(key);
            }
        });
        return rovers;
    }

    private Rover operateRover(Rover key, List<Command> value, UserInput userInput) {
        for (Command command : value) {
            if (command.equals(Command.M)) {
                key.moveRover(userInput.getRoverListMap(), userInput.getPlateau());
            } else {
                key.rotateRover(command);
            }
        }
        return key;
    }

    public void reportRoverStatus(List<Rover> rovers) {
        rovers.forEach(rover -> {
            System.out.println(rover.toString());
        });
    }
}
