package test.view;

import org.junit.jupiter.api.Test;
import view.ViewConsole;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class ViewConsoleTest {
    private ViewConsole view;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @Test
    void testInput() {
        String input = "test input";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        view = new ViewConsole();
        assertEquals(input, view.input());
    }

    @Test
    void testOutput() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        view = new ViewConsole();
        String message = "test message";
        view.output(message);
        
        assertEquals(message + System.lineSeparator(), outputStream.toString());
        System.setOut(originalOut);
    }

    @Test
    void testClear() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        view = new ViewConsole();
        view.clear();
        
        assertEquals("\033[H\033[2J", outputStream.toString());
        System.setOut(originalOut);
    }

    @Test
    void testShowWelcome() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        view = new ViewConsole();
        view.showWelcome();
        
        String expected = "\033[H\033[2J" +
                "=== Игра 'Орел и Решка' ===" + System.lineSeparator() +
                "Добро пожаловать!" + System.lineSeparator() +
                "========================" + System.lineSeparator();
        assertEquals(expected, outputStream.toString());
        System.setOut(originalOut);
    }
} 