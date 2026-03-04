package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GamePositionTest {
    private static final int SIZE = 5;
    GamePositionImpl position;

    @Test
    public void testValidPosition() {
        Pair<Integer, Integer> validObject1 = new Pair<>(3, 2);
        Pair<Integer, Integer> validObject2 = new Pair<>(1, 1);
        position = new GamePositionImpl(SIZE, validObject1, validObject2);
        assertEquals(position.getPosition1(), validObject1);
        assertEquals(position.getPosition2(), validObject2);
    }

    @Test
    public void testOutOfBoundPosition(){
        Pair<Integer, Integer> outOfBoundObject = new Pair<>(5,5);
        position = new GamePositionImpl(SIZE, outOfBoundObject, outOfBoundObject);
        assertNotEquals(position.getPosition1(), outOfBoundObject);
        assertNotEquals(position.getPosition2(), outOfBoundObject);
        assertNotEquals(position.getPosition1(), position.getPosition2());
    }

    @Test
    public void testGetDistance(){
        int coordinate1 = 2;
        int coordinate2 = 3;
        int expectedDistance = -1;
        assertEquals(expectedDistance, GamePosition.getDistance(coordinate1, coordinate2));
    }
}
