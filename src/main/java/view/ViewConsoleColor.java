package view;

import java.util.Scanner;

public class ViewConsoleColor implements View {
    private final Scanner scanner;
    
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public ViewConsoleColor() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String input() {
        System.out.print(CYAN + "> " + RESET);
        return scanner.nextLine().trim();
    }

    @Override
    public void output(String message) {
        if (message.contains("выиграли") || message.contains("Поздравляем")) {
            System.out.println(GREEN + message + RESET);
        } else if (message.contains("проиграли") || message.contains("К сожалению")) {
            System.out.println(RED + message + RESET);
        } else if (message.contains("Статистика")) {
            System.out.println(YELLOW + message + RESET);
        } else {
            System.out.println(message);
        }
    }

    @Override
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void showWelcome() {
        clear();
        output(PURPLE + "=== Игра 'Орел и Решка' ===" + RESET);
        output(BLUE + "Добро пожаловать!" + RESET);
        output(PURPLE + "========================" + RESET);
    }
}
