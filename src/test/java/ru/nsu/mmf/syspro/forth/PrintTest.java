package ru.nsu.mmf.syspro.forth;

import junit.framework.TestCase;
import org.junit.Test;

public class PrintTest {

    @Test
    public void testAll() {
        cr();
        printNum();
        emit();
        printString();
    }

    @Test
    public void cr() {

        String input = "1 . cr 1 .";
        String expected = "1\n1";
        String result = ForthTest.test(input);

        TestCase.assertEquals(expected, result);

    }

    @Test
    public void printNum() {
        String input = "1 .";
        String expected = "1";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void emit() {
        String input = "65 emit";
        String expected = "A";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void printString() {
        String input = "4 .\" string content\"";
        String expected = "string content";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }


}
