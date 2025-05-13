package view;

import java.util.Scanner;

public class ViewConsole implements View {
    private final Scanner scanner;

    public ViewConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String input() {
        return scanner.nextLine().trim();
    }

    @Override
    public void output(String message) {
        System.out.println(message);
    }

    @Override
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void showWelcome() {
        clear();
        output("=== Игра 'Орел и Решка' ===");
        output("Добро пожаловать!");
        output("========================");
    }
}
