package ru.nsu.mmf.syspro.forth;

import ru.nsu.mmf.syspro.forth.executable.Main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class ForthTest {

    static String test(String input) {

        System.setIn(new ByteArrayInputStream((input + " exit").getBytes(StandardCharsets.UTF_8)));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(byteArrayOutputStream);

        Main.execute(output);

        return byteArrayOutputStream.toString();
    }

}
