package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {

  public static void main(String[] args) {

    Flux.interval(Duration.ofSeconds(1))
            .subscribe(Util.onNext());

    // we need to block the main thread to see things happening because the
    // Flux above is async and non-blocking
    Util.sleepSeconds(5);
  }
}
