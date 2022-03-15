import service.Execution;

import java.io.IOException;
import java.util.LinkedHashMap;

public class MarsRoversApplication {
    public static void main(String[] args) throws IOException {
        String fileName = "TestCases/test1";
        fileName = "input";
        Execution execution = new Execution();
        execution.execute(fileName);
    }
}
