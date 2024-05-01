package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

  public static void main(String[] args) {

    Flux.generate(synchronousSink -> {
      synchronousSink.next(Util.faker().country().name());
    })
    .take(2)
    .subscribe(Util.subscriber());
  }
}
