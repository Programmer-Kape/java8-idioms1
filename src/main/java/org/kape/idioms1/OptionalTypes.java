package org.kape.idioms1;

import java.util.Optional;

public class OptionalTypes {

  private static Optional<Integer> optionalInteger = Optional.ofNullable(null);

  private static Optional<String> optionalString = Optional.empty();

  public static void main(String[] args) {
    System.out.println("Int is " + optionalInteger.orElse(0));
  }
}
