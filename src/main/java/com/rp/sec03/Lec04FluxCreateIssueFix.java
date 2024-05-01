package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Lec04FluxCreateIssueFix {

  public static void main(String[] args) {

    // only one instance of FluxSink
    Flux.create(Lec04FluxCreateIssueFix::countryPublisher)
            .take(3)
            .subscribe(Util.subscriber());
  }

  private static void countryPublisher(final FluxSink<String> fluxSink) {
    String country;

    do {
      country = Util.faker().country().name();
      System.out.println("emitting: " + country);
      fluxSink.next(country);
    } while (keepEmitting(country, fluxSink));

    fluxSink.complete();
  }

  private static boolean keepEmitting(final String country, final FluxSink<String> fluxSink) {
    return !country.equalsIgnoreCase("Canada") && !fluxSink.isCancelled();
  }
}
