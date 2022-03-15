import service.Execution;

import java.io.IOException;

public class MarsRoversApplication {
    public static void main(String[] args) throws IOException {
        Execution execution = new Execution();
        execution.execute(args[0]);
    }
}
