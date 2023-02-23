package view;

public class ViewConsoleColor extends ViewConsole {

  public static final String COLOR_RESET = "\u001B[0m";
  public static final String COLOR_GREEN = "\u001B[32m";

  @Override
  public void output(String message) {
    System.out.print(COLOR_GREEN);
    super.output(message);
    System.out.print(COLOR_RESET);
  }
}
