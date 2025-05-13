package view;

public interface View {

  /**
   * Gets input from the user
   * @return the user's input as a String
   */
  String input();

  /**
   * Displays a message to the user
   * @param message the message to display
   */
  void output(String message);

  /**
   * Clears the display
   */
  void clear();

  /**
   * Displays a welcome message
   */
  void showWelcome();

}
