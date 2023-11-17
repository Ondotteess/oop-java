package ru.nsu.mmf.syspro.forth;


import junit.framework.TestCase;
import org.junit.Test;
import ru.nsu.mmf.syspro.forth.executable.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ArithmeticTest {

    @Test
    public void testAll(){
        loadNumbers();
        plus();
        minus();
        mod();
        multiply();
        division();
    }

    @Test
    public void loadNumbers() {

        String input = "1 2 3 4 5";
        String expected = "";
        String result = ForthTest.test(input);

        TestCase.assertEquals(expected, result);

    }

    @Test
    public void plus() {
        String input = "1 3 + .";
        String expected = "4";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void minus() {
        String input = "2 3 - .";
        String expected = "-1";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void mod() {
        String input = "4 3 mod .";
        String expected = "1";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void multiply() {
        String input = "2 3 * .";
        String expected = "6";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }

    @Test
    public void division() {
        String input = "6 2 / .";
        String expected = "3";
        String result = ForthTest.test(input);
        TestCase.assertEquals(expected, result);

    }
}
