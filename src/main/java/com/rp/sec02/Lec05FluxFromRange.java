package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxFromRange {

  public static void main(String[] args) {

    Flux<String> namesFlux = Flux.range(1, 10)
            .log()
            .map(i -> Util.faker().name().fullName())
            .log();
    namesFlux.subscribe(Util.onNext());
  }
}
