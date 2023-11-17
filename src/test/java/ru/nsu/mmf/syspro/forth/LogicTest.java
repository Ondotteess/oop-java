package ru.nsu.mmf.syspro.forth;

import junit.framework.TestCase;
import org.junit.Test;

public class LogicTest {

    @Test
    public void testAll() {
        equal();
        greater();
        less();
    }

    @Test
    public void equal() {
        String input = "4 4 = .";
        String expected = "1";
        String result = ForthTest.test(input);

        TestCase.assertEquals(expected, result);

    }

    @Test
    public void greater() {
        String input = "1 2 > .";
        String expected = "1";
        String result = ForthTest.test(input);

        TestCase.assertEquals(expected, result);

    }

    @Test
    public void less() {
        String input = "1 2 < .";
        String expected = "0";
        String result = ForthTest.test(input);

        TestCase.assertEquals(expected, result);

    }
}
