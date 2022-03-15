package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {
    private Plateau plateau;

    @BeforeEach
    void init() {
        plateau = new Plateau(new Position(5,5));
    }

    @Test
    void isInPlateau() {
        assertEquals(true,plateau.inPlateau(3,3));
    }

    @Test
    void isNotInPlateau() {
        assertEquals(false,plateau.inPlateau(-3,-3));
    }
}