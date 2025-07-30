package edition2024;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.InputReader;
import utils.Solution;

public class DayOne extends Solution {
    InputReader ir = new InputReader();

    public void solve() throws IOException {
        List<ArrayList<Integer>> inputLists = ir.readToTwoLists("day1.txt");
        List<Integer> sortedLeftList = inputLists.get(0).stream().sorted().toList();
        List<Integer> sortedRightList = inputLists.get(1).stream().sorted().toList();

        int sumOfsmallestDifference = 0;

        for (int i = 0; i < sortedLeftList.size(); i++) {
            sumOfsmallestDifference += calculateDifference(sortedLeftList.get(i),
                sortedRightList.get(i));
        }
        answerOne = sumOfsmallestDifference;

        answerTwo = caluclateSimilarity(sortedLeftList, sortedRightList);
    }

    public int calculateDifference(int a, int b) {
        return Math.abs(a - b);
    }

    public int caluclateSimilarity(List<Integer> firstList, List<Integer> secondList) {
        int similarityScore = 0;
        for (int number : firstList) {
            similarityScore += number * Collections.frequency(secondList, number);
        }
        return similarityScore;
    }


}
