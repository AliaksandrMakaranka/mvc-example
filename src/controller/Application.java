package controller;

import model.Coin;
import view.View;

public class Application {

  private final View view;

  public Application(View view) {
    this.view = view;
  }

  public void start() {
    view.output("ваша ставка");
    String bet = "";
    while (true) {
      bet = view.input();
      if (bet.equalsIgnoreCase(Coin.OBVERSE) || bet.equalsIgnoreCase(Coin.REVERSE)) {
        break;
      } else {
        view.output("не правильное имя ставки, нужно: " + Coin.OBVERSE + " или " + Coin.REVERSE);
      }
    }
    Coin coin = new Coin();
    String winResult = coin.drop();
    view.output("мы подкинули монетку: " + winResult);
    if (winResult.equalsIgnoreCase(bet)) {
      view.output("вы выиграли!!!");
    } else {
      view.output("вы проиграли");
    }
  }

}
