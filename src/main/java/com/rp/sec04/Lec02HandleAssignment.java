package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Lec02HandleAssignment {

  public static void main(String[] args) {

    Flux.generate(countryGenerator())
            .handle(handleCountries())
            .subscribe(Util.subscriber());
  }

  private static Consumer<SynchronousSink<String>> countryGenerator() {
    return sink -> sink.next(Util.faker().country().name());
  }

  private static BiConsumer<String, SynchronousSink<String>> handleCountries() {
    return (country, sink) -> {
      sink.next(country);
      if (country.equalsIgnoreCase("Canada")) {
        sink.complete();
      }
    };
  }
}
