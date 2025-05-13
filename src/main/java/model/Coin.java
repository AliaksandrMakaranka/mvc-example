package model;

import java.util.Random;

public class Coin {

  public static final String OBVERSE = "орел";
  public static final String REVERSE = "решка";

  private final Random random;
  private String lastResult;
  private int totalFlips;
  private int wins;

  public Coin() {
    this.random = new Random();
    this.totalFlips = 0;
    this.wins = 0;
  }

  public String flip() {
    int number = random.nextInt(2);
    lastResult = (number == 0) ? OBVERSE : REVERSE;
    totalFlips++;
    return lastResult;
  }

  public boolean checkWin(String bet) {
    if (lastResult == null) {
      throw new IllegalStateException("No coin flip has been performed yet");
    }
    boolean isWin = lastResult.equalsIgnoreCase(bet);
    if (isWin) {
      wins++;
    }
    return isWin;
  }

  public String getLastResult() {
    return lastResult;
  }

  public int getTotalFlips() {
    return totalFlips;
  }

  public int getWins() {
    return wins;
  }

  public double getWinRate() {
    return totalFlips == 0 ? 0 : (double) wins / totalFlips;
  }

}
