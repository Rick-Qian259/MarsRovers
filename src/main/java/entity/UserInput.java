package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class UserInput {
    private final Plateau plateau;
    private LinkedHashMap<Rover, List<Command>> roverListMap;

}
