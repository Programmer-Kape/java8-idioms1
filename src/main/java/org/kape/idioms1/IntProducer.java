package org.kape.idioms1;

import java.util.Random;

public class IntProducer {

  private Random random = new Random();

  public int generate() {
    return random.nextInt();
  }
}
