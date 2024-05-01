package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Lec01FluxCreate {

  public static void main(String[] args) {

    Flux.create(Lec01FluxCreate::countryPublisher)
    .subscribe(Util.subscriber());
  }

  private static void countryPublisher(final FluxSink<String> fluxSink) {
    String country;

    do {
      country = Util.faker().country().name();
      fluxSink.next(country);
    } while (!country.equalsIgnoreCase("Canada"));

    fluxSink.complete();
  }
}
