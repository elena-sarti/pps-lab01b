package it.unibo.pps.e2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    private static final int SIZE = 5;
    PositionImpl position;

    @Test
    public void testOutOfBoundPosition(){
        Pair<Integer, Integer> outOfBoundObject = new Pair<>(5,5);
        position = new PositionImpl(SIZE, outOfBoundObject, outOfBoundObject);
        assertNotEquals(position.object1, outOfBoundObject);
        assertNotEquals(position.object2, outOfBoundObject);
        assertNotEquals(position.object1, position.object2);
    }

    @Test
    public void testValidPosition() {
        Pair<Integer, Integer> validPosition1 = new Pair<>(3, 2);
        Pair<Integer, Integer> validPosition2 = new Pair<>(2, 1);
        position = new PositionImpl(SIZE, validPosition1, validPosition2);
        assertEquals(position.object1, validPosition1);
        assertEquals(position.object2, validPosition2);
    }
}
