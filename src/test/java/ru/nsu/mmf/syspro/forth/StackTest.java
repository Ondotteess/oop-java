package ru.nsu.mmf.syspro.forth;

import junit.framework.TestCase;
import org.junit.Test;

public class StackTest {

    public void testAll(){
        drop();
        printNum();
        over();
        rot();
        swap();
    }

    @Test
    public void drop() {

        String input = "1 2 drop .";
        String expected = "1";
        String result = ForthTest.test(input);

        TestCase.assertEquals(expected, result);

    }

    @Test
    public void printNum() {
        String input = "1 dup . .";
        String expected = "11";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void over() {
        String input = "1 2 over .";
        String expected = "1";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void rot() {
        String input = "1 2 3 rot . . .";
        String expected = "213";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void swap() {
        String input = "1 2 swap .";
        String expected = "1";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

}
