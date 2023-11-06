package org.kape.idioms1;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamingApi {

  private Supplier<Integer> intProducer = new IntProducer()::generate;

  private List<Integer> numbers = List.of(
      intProducer.get(),
      intProducer.get(),
      intProducer.get(),
      intProducer.get(),
      intProducer.get(),
      intProducer.get(),
      intProducer.get(),
      intProducer.get(),
      intProducer.get()
  );

  public void execute() {
    String csv = numbers.stream()
        .map(number -> String.valueOf(number))
        .collect(Collectors.joining(", "));
  }
}
