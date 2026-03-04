package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GamePositionTest {
    private static final int SIZE = 5;
    GamePositionImpl position;

    @Test
    public void testValidPosition() {
        Pair<Integer, Integer> validPawn = new Pair<>(3, 2);
        Pair<Integer, Integer> validKnight = new Pair<>(1, 1);
        position = new GamePositionImpl(SIZE, validPawn, validKnight);
        assertEquals(position.getPawn(), validPawn);
        assertEquals(position.getKnight(), validKnight);
    }

    @Test
    public void testOutOfBoundPosition(){
        Pair<Integer, Integer> outOfBoundObject = new Pair<>(5,5);
        position = new GamePositionImpl(SIZE, outOfBoundObject, outOfBoundObject);
        assertNotEquals(position.getPawn(), outOfBoundObject);
        assertNotEquals(position.getKnight(), outOfBoundObject);
        assertNotEquals(position.getPawn(), position.getKnight());
    }

    @Test
    public void testGetDistance(){
        int coordinate1 = 2;
        int coordinate2 = 3;
        int expectedDistance = -1;
        assertEquals(expectedDistance, GamePosition.getDistance(coordinate1, coordinate2));
    }
}
