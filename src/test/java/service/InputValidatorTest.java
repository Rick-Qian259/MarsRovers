package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {
    private InputValidator inputValidator;
    private String fileName;

    @BeforeEach
    void init() {
        fileName = "input";
        inputValidator = new InputValidator();
    }

    @Test
    void checkInputPass() throws IOException {
        inputValidator.checkInput(fileName);
    }

    @Test
    void throwException() {
        fileName = "testCases/input1";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: -5 5", exception.getMessage());
    }

    @Test
    void plateauHasNegativeNumber() {
        fileName = "testCases/input1";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: -5 5", exception.getMessage());
    }

    @Test
    void plateauMoreThanTwoNumbers() {
        fileName = "testCases/input2";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: 5 5 4", exception.getMessage());
    }

    @Test
    void plateauHasLetter() {
        fileName = "testCases/input3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: N 5 5", exception.getMessage());
    }

    @Test
    void plateauHasNumberZero() {
        fileName = "testCases/input4";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: 0 0", exception.getMessage());
    }

    @Test
    void roverNoDirection() {
        fileName = "testCases/input5";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: 1 2", exception.getMessage());
    }

    @Test
    void roverNegativeNumber() {
        fileName = "testCases/input6";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: 1 -2 N", exception.getMessage());
    }

    @Test
    void roverErrorDirection() {
        fileName = "testCases/input7";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("No enum constant entity.Direction.A", exception.getMessage());
    }

    @Test
    void commandError() {
        fileName = "testCases/input8";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("No enum constant entity.Command.A", exception.getMessage());
    }

    @Test
    void checkCommandHasTwoLines1() throws IOException {
        fileName = "testCases/input9";
        inputValidator.checkInput(fileName);
    }

    @Test
    void checkOneRoverHasNoCommand() throws IOException {
        fileName = "testCases/input10";
        inputValidator.checkInput(fileName);
    }

    @Test
    void checkRoverCrash() {
        fileName = "testCases/input11";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: 1 2 E", exception.getMessage());
    }

    @Test
    void checkRoverOutOfPlateau() {
        fileName = "testCases/input12";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.checkInput(fileName);
        });
        assertEquals("Incorrect input in line: 1 20 N", exception.getMessage());
    }

    @Test
    void checkCommandHasNumber() {
        InputValidator inputValidator1 = new InputValidator();
        String fileName1 = "testCases/input13";
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            inputValidator1.checkInput(fileName1);
        });
        assertEquals("Incorrect input in line: LMLMLMLMM 3 3", exception1.getMessage());
    }



}