package org.kape.idioms1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaIdiom {

  public void print() {
    System.out.println("Hello");
  }

  static Consumer<String> consumer = arg -> System.out.println("Hello " + arg);

  static Supplier<String> supplier = () -> "a Supplier.";

  static Function<String, Integer> intParser = String::length;

  public static void main(String[] args) {
    int length = intParser.apply("Supercalifragilisticexpialidocious");
    System.out.println(length);
  }

}
