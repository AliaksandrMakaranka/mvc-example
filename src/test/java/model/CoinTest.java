package test.model;

import model.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
    private Coin coin;

    @BeforeEach
    void setUp() {
        coin = new Coin();
    }

    @Test
    void testInitialState() {
        assertEquals(0, coin.getTotalFlips());
        assertEquals(0, coin.getWins());
        assertEquals(0.0, coin.getWinRate());
        assertNull(coin.getLastResult());
    }

    @Test
    void testFlip() {
        String result = coin.flip();
        assertTrue(result.equals(Coin.OBVERSE) || result.equals(Coin.REVERSE));
        assertEquals(1, coin.getTotalFlips());
        assertEquals(result, coin.getLastResult());
    }

    @Test
    void testCheckWin() {
        coin.flip();
        String lastResult = coin.getLastResult();

        assertTrue(coin.checkWin(lastResult));
        assertEquals(1, coin.getWins());
        assertEquals(1.0, coin.getWinRate());

        // flip until result is different from lastResult
        String newResult;
        do {
            coin.flip();
            newResult = coin.getLastResult();
        } while (newResult.equals(lastResult));

        assertFalse(coin.checkWin(lastResult));
        assertEquals(1, coin.getWins());
        assertEquals(0.5, coin.getWinRate());
    }

    @Test
    void testCheckWinWithoutFlip() {
        assertThrows(IllegalStateException.class, () -> coin.checkWin(Coin.OBVERSE));
    }
} 