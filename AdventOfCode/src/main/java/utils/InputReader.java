package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    public List<ArrayList<Integer>> readToTwoLists(String filename) throws IOException {
        ArrayList<Integer> firstList = new ArrayList<Integer>();
        ArrayList<Integer> secondList = new ArrayList<Integer>();
        List<String> inputLines = readToStringList(filename);
        for (String line: inputLines) {
            String[] words = line.split("\\s+");
            if (words.length != 2) {
                throw new IOException("Lines in this file contain more than two words");
            }
            firstList.add(Integer.valueOf(words[0]));
            secondList.add(Integer.valueOf(words[1]));
        }

        return List.of(firstList, secondList);
    }

    public List<String> readToStringList(String filename) throws IOException {
        InputStream is = getClass().getResourceAsStream("/" + filename);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new RuntimeException("File %s not found".formatted(filename), e);
        }
    }
}
