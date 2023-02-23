package view;

import java.util.Scanner;

public class ViewConsole implements View{

  @Override
  public String input() {
    Scanner scanner = new Scanner(System.in);
    return scanner.next();
  }

  @Override
  public void output(String message) {
    System.out.println(message);
  }
}
