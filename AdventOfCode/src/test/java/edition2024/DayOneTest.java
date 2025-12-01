package edition2024;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DayOneTest {
    Day01 day;

    @BeforeEach
    void setUp() {
        day = new Day01();
    }

    @Test
    void calculateDifference() {
        assert(day.calculateDifference(0, 0) == 0);
        assert(day.calculateDifference(-1, 4) == 5);
        assert(day.calculateDifference(4, -1) == 5);
        assert(day.calculateDifference(-1, -2) == 1);
        assert(day.calculateDifference(1, 2) == 1);
    }

    @Test
    void caluclateSimilarity() {
        List<Integer> firstList = List.of(3, 4, 2, 1, 3, 3);
        List<Integer> secondList = List.of(4, 3, 5, 3, 9, 3);
        assert(day.caluclateSimilarity(firstList, secondList) == 31);
    }
}