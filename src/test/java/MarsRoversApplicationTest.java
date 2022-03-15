import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoversApplicationTest {

    @Test
    void mainPass() throws IOException {
        String[] args = {"input",""};
        MarsRoversApplication.main(args);
    }

    @Test
    void threeRovers() throws IOException {
        String[] args = {"correctCases/input1",""};
        MarsRoversApplication.main(args);
    }
}