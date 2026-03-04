package it.unibo.pps.e2;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;


public class LogicTest {

    private static final int SIZE = 5;
    private LogicsImpl logics;
    private Pair<Integer,Integer> pawn;
    private Pair<Integer,Integer> knight;

    @BeforeEach
    public void init(){
        this.pawn = new Pair<>(3, 4);
        this.knight = new Pair<>(1,3);
        this.logics = new LogicsImpl(new GamePositionImpl(SIZE, this.pawn, this.knight));
    }

    @Test
    public void testSetUp(){
        assertEquals(this.pawn, logics.pawn);
        assertNotEquals(logics.knight, logics.pawn);
    }

    @Test
    public void testHasPawn(){
        assertTrue(logics.hasPawn(this.pawn.getX(), this.pawn.getY()));
    }

    @Test
    public void testHasKnight(){
        assertTrue(logics.hasKnight(this.knight.getX(), this.knight.getY()));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 2, false",
            "1, 2, true"
    })
    public void testAllowedMove(int orizontalDistance, int verticalDistance, boolean expectedResult){
        assertEquals(expectedResult, logics.isMoveAllowed(orizontalDistance, verticalDistance));
    }

    @Test
    public void testHitOutOfBounds(){
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(SIZE, SIZE));
    }

    @Test
    public void testHit(){
        assertTrue(logics.hit(this.pawn.getX(),this.pawn.getY()));
    }

}
