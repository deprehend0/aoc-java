package edition2025;

import java.io.IOException;
import java.util.List;
import utils.InputReader;
import utils.Solution;

public class Day01 extends Solution {
    InputReader ir = new InputReader();

    @Override
    public void solve() throws IOException {
        List<String> rotations = ir.readToStringList("2025/day01.txt");
        int dialPos = 50;
        int dialPos2 = 50;
        int[] answer;
        for (String rotation : rotations) {
            String direction = String.valueOf(rotation.charAt(0));
            int clicks = Integer.parseInt(rotation.substring(1));
//            dialPos = calucalteNewDialPos(dialPos, direction, clicks); // Only needed for part 1, also answered in answer[0]
            answer = calucalteNewDialPosWithPassedZeroCount(dialPos, direction, clicks);
            dialPos = answer[0];
            answerTwo += answer[1];
            if (dialPos == 0) {
                answerOne++;
            }
        }
    }

    public int calucalteNewDialPos(int dialPos, String direction, int clicks){
        if (direction.equals("R")) {
            dialPos = (dialPos + clicks) % 100;
        } else {
            dialPos = (dialPos - clicks) % 100;
        }
        if (dialPos < 0) {
            dialPos = dialPos + 100;
        }
        return dialPos;
    }

    public int[] calucalteNewDialPosWithPassedZeroCount(int dialPos, String direction, int clicks){
        int passedZero = (int) Math.floor(clicks / 100);
        int oldClicks = clicks;
        clicks = clicks % 100;
        int oldDialPos = dialPos;

        int newPos = calucalteNewDialPos(dialPos, direction, clicks);
        boolean belowZero = direction.equals("L") && (oldDialPos - clicks < 0) && (oldDialPos != 0);
        boolean aboveHundred = direction.equals("R") && (oldDialPos + clicks > 100) && (oldDialPos != 0);
        if (newPos == 0 || belowZero || aboveHundred) {
            passedZero ++;
        }

        return new int[]{newPos, passedZero};
    }

}
