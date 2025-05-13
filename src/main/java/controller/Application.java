package controller;

import model.Coin;
import view.View;

public class Application {

  private final View view;
  private final Coin coin;
  private boolean isGameRunning;

  public Application(View view) {
    this.view = view;
    this.coin = new Coin();
    this.isGameRunning = true;
  }

  public void start() {
    view.output("Добро пожаловать в игру 'Орел и Решка'!");
    view.output("Введите 'exit' для выхода из игры");
    
    while (isGameRunning) {
      playRound();
      showStatistics();
      askToContinue();
    }
    
    view.output("Спасибо за игру!");
  }

  private void playRound() {
    view.output("\nВаша ставка (" + Coin.OBVERSE + " или " + Coin.REVERSE + "):");
    String bet = getValidBet();
    
    if (bet.equalsIgnoreCase("exit")) {
      isGameRunning = false;
      return;
    }

    String result = coin.flip();
    view.output("Монетка упала: " + result);
    
    if (coin.checkWin(bet)) {
      view.output("Поздравляем! Вы выиграли!");
    } else {
      view.output("К сожалению, вы проиграли");
    }
  }

  private String getValidBet() {
    while (true) {
      String input = view.input();
      if (input.equalsIgnoreCase("exit")) {
        return input;
      }
      if (input.equalsIgnoreCase(Coin.OBVERSE) || input.equalsIgnoreCase(Coin.REVERSE)) {
        return input;
      }
      view.output("Неверная ставка! Введите: " + Coin.OBVERSE + " или " + Coin.REVERSE);
    }
  }

  private void showStatistics() {
    view.output("\nСтатистика игры:");
    view.output("Всего бросков: " + coin.getTotalFlips());
    view.output("Побед: " + coin.getWins());
    view.output("Процент побед: " + String.format("%.1f%%", coin.getWinRate() * 100));
  }

  private void askToContinue() {
    if (isGameRunning) {
      view.output("\nХотите сыграть еще раз? (да/нет)");
      String answer = view.input();
      isGameRunning = answer.equalsIgnoreCase("да");
    }
  }

}
