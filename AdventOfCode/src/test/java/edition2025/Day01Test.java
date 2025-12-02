package edition2025;

import edition2025.Day01;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day01Test {
    Day01 day01;

    @BeforeEach
    void setUp() {
        day01 = new Day01();
    }

    @Test
    void computeRotation() {
        int dialPos = 50;
        int dialPos2 = 50;
        List<String> rotations = List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82", "R201", "L408");
        List<Integer> answers = List.of(82, 52, 0, 95, 55, 0, 99, 0, 14, 32, 33, 25);
        List<Integer> passedZero = List.of(1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 2, 4);
        int sumOfPassedZero = 0;
        for (int i = 0; i < rotations.size(); i++) {
            String direction = String.valueOf(rotations.get(i).charAt(0));
            int clicks = Integer.parseInt(rotations.get(i).substring(1));
            dialPos = day01.calucalteNewDialPos(dialPos, direction, clicks);
            int[] answer = day01.calucalteNewDialPosWithPassedZeroCount(dialPos2, direction, clicks);
            dialPos2 = answer[0];
            sumOfPassedZero += answer[1];
            Assertions.assertEquals(passedZero.get(i), answer[1]);
            Assertions.assertEquals(answers.get(i), answer[0]);
            Assertions.assertEquals(answers.get(i), dialPos);
        }
        Assertions.assertEquals(12, sumOfPassedZero);
    }
}