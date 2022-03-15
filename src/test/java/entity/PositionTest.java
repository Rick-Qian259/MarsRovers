package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    private Position position;

    @BeforeEach
    void init() {
        position = new Position(4,4);
    }

    @Test
    void inSamePosition() {
        assertEquals(true, position.inSamePosition(4,4));
    }

    @Test
    void inDifferentPosition() {
        assertEquals(false, position.inSamePosition(3,3));
    }
}