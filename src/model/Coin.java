package model;

import java.util.Random;

public class Coin {

  public static final String OBVERSE = "орел";
  public static final String REVERSE = "решка";

  public String drop() {
    Random random = new Random();
    int number = random.nextInt(2);
    return (number == 0) ? OBVERSE : REVERSE;
  }

}
