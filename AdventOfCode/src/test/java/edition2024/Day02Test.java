package edition2024;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day02Test {
    private Day02 day;

    @BeforeEach
    void setUp() {
        day = new Day02();
    }

    @Test
    void isSafeTest() {
        assertTrue(day.isSafe(List.of(7, 6, 4, 2, 1)),"Safe because the levels are all decreasing by 1 or 2.");
        assertFalse(day.isSafe(List.of(1, 2, 7, 8, 9)), "Unsafe because 2 7 is an increase of 5");
        assertFalse(day.isSafe(List.of(9, 7, 6, 2, 1)), "Unsafe because 6 2 is a decrease of 4.");
        assertFalse(day.isSafe(List.of(1, 3, 2, 4, 5)), "Unsafe because 1 3 is increasing but 3 2 is decreasing.");
        assertFalse(day.isSafe(List.of(8, 6, 4, 4, 1)), "Unsafe because 4 4 is neither an increase or a decrease.");
        assertTrue(day.isSafe(List.of(1, 3, 6, 7, 9)), "Safe because the levels are all increasing by 1, 2, or 3.");
    }
}