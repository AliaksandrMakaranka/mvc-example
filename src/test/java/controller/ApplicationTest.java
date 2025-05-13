package controller;

import controller.Application;
import model.Coin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.View;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

class ApplicationTest {
    private Application application;
    private TestView testView;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    private static class TestView implements View {
        private final ByteArrayInputStream inputStream;
        private final ByteArrayOutputStream outputStream;
        private final Scanner scanner;

        public TestView(String input) {
            this.inputStream = new ByteArrayInputStream(input.getBytes());
            this.outputStream = new ByteArrayOutputStream();
            this.scanner = new Scanner(this.inputStream);
        }

        @Override
        public String input() {
            return scanner.hasNextLine() ? scanner.nextLine().trim() : "";
        }

        @Override
        public void output(String message) {
            try {
                outputStream.write(message.getBytes());
                outputStream.write(System.lineSeparator().getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error writing output", e);
            }
        }

        @Override
        public void clear() {
            try {
                outputStream.write("\033[H\033[2J".getBytes());
            } catch (IOException e) {
                throw new RuntimeException("Error clearing screen", e);
            }
        }

        @Override
        public void showWelcome() {
            output("=== Игра 'Орел и Решка' ===");
            output("Добро пожаловать!");
            output("========================");
        }

        public String getOutput() {
            return outputStream.toString();
        }
    }

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testGameFlow() {
        String input = "орел\nexit";
        testView = new TestView(input);
        application = new Application(testView);
        
        application.start();
        
        String output = testView.getOutput();
        assertTrue(output.contains("Добро пожаловать"));
        assertTrue(output.contains("Ваша ставка"));
        assertTrue(output.contains("Монетка упала"));
        assertTrue(output.contains("Статистика игры"));
    }

    @Test
    void testInvalidInput() {
        String input = "invalid\nорел\nexit";
        testView = new TestView(input);
        application = new Application(testView);
        
        application.start();
        
        String output = testView.getOutput();
        assertTrue(output.contains("Неверная ставка"));
    }

    @Test
    void testGameStatistics() {
        String input = "орел\nнет";
        testView = new TestView(input);
        application = new Application(testView);
        
        application.start();
        
        String output = testView.getOutput();
        assertTrue(output.contains("Всего бросков: 1"));
        assertTrue(output.contains("Побед:"));
        assertTrue(output.contains("Процент побед:"));
    }
} 