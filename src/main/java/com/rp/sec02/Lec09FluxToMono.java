package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec09FluxToMono {

  public static void main(String[] args) {

    Flux<Integer> integers = Flux.range(1, 10);
    integers
            .filter(i -> i > 3)
            .next()
            .subscribe(
                    Util.onNext(),
                    Util.onError(),
                    Util.onComplete());
  }
}
