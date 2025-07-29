package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputReaderTest {
    InputReader ir;

    @BeforeEach
    void setUp() {
        ir = new InputReader();
    }

    @Test
    void readToTwoListsTest() throws IOException {
        List<ArrayList<Integer>> list = ir.readToTwoLists("twoIntegerLists.txt");

        assert(list.size() == 2);
        assert(list.get(0).equals(List.of(77889, 21290, 12281, 58526)));
        assert(list.get(1).equals(List.of(56829, 65255, 42665, 23054)));
    }

    @Test
    void readToStringListTest() throws IOException {
        List<String> strings = ir.readToStringList("twoIntegerLists.txt");
        assert(strings.size() == 4);
        assert(strings.equals(List.of("77889   56829", "21290   65255", "12281   42665", "58526   23054")));
    }
}