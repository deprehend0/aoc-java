package utils;

import java.io.IOException;

public abstract class Solution {
    protected int answerOne;
    protected int answerTwo;

    public abstract void solve() throws IOException;

    public void printSolutions() {
        System.out.println("Day 01 - part 1: " + answerOne);
        System.out.println("Day 01 - part 2: " + answerTwo);
    }

}
