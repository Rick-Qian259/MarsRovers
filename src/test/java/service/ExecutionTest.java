package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExecutionTest {

    private Execution execution;

    @BeforeEach
    void init() {
        execution = new Execution();
    }

    @Test
    void executeTest() throws IOException {
        execution.execute("input");
    }
}